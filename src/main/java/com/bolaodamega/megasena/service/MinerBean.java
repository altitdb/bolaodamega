package com.bolaodamega.megasena.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.ExcludedGame;
import com.bolaodamega.megasena.domain.Game;
import com.bolaodamega.megasena.domain.MineGame;
import com.bolaodamega.megasena.repository.ExcludedGameRepository;
import com.bolaodamega.megasena.repository.MineGameRepository;
import com.bolaodamega.megasena.roles.NumbersLateralRole;
import com.bolaodamega.megasena.roles.NumbersOddsAndEvenRole;
import com.bolaodamega.megasena.roles.NumbersSameColumnRole;
import com.bolaodamega.megasena.roles.NumbersSameRowRole;
import com.bolaodamega.megasena.roles.NumbersSequentialRole;
import com.bolaodamega.megasena.roles.Role;

@Order(value = 2)
@Controller
public class MinerBean implements CommandLineRunner {
    
    @Autowired
    private MineGameRepository mineGameRepository;
    
    @Autowired
    private ExcludedGameRepository excludedGameRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOG = Logger.getLogger(MinerBean.class);

    private Set<Role> roles = new HashSet<>();

    private boolean miner(MineGame game) {
        LOG.debug("VALIDATING " + game);
        roles.add(new NumbersSequentialRole());
        roles.add(new NumbersOddsAndEvenRole());
        roles.add(new NumbersSameRowRole());
        roles.add(new NumbersSameColumnRole());
        roles.add(new NumbersLateralRole());
        for (Role role : roles) {
            boolean isInvalid = role.validate(game);
            entityManager.detach(game);
            if (isInvalid) {
                LOG.debug("INVALID " + game);
                removeGame(game, role);
            }
            return isInvalid;
        }
        return false;
    }

    private void removeGame(Game game, Role role) {
        LOG.debug("SAVING EXCLUDED " + game);
        ExcludedGame newGame = new ExcludedGame();
        newGame.setGamePk(game.getGamePk());
        newGame.setRole(role);
        excludedGameRepository.save(newGame);
        LOG.debug("EXCLUDING " + game);
        mineGameRepository.delete(game.getGamePk());
        entityManager.clear();
    }

    public void start() {
        final int pageSize = 1000;
        int start = 0;
        Slice<MineGame> mineGameStream;
        do {
        	boolean nextPage = true;
            LOG.debug("STARTING SEARCH IN " + start);
            mineGameStream = mineGameRepository.findAllBy(new PageRequest(start, pageSize));
            LOG.debug("TOTAL: " + mineGameStream.getSize());
            for (MineGame mineGame : mineGameStream) {
                boolean isInvalid = miner(mineGame);
                if (isInvalid) {
                    nextPage = false;
                }
            }
            if (nextPage) {
                start++;
            }
            entityManager.clear();
        } while (mineGameStream.hasNext());
    }

    public MineGameRepository getMineGameRepository() {
        return mineGameRepository;
    }

    public void setMineGameRepository(MineGameRepository mineGameRepository) {
        this.mineGameRepository = mineGameRepository;
    }

    @Override
    public void run(String... arg0) throws Exception {
        LOG.info("STARTED");
        start();
        LOG.info("FINISHED");
    }

}
