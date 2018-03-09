package com.bolaodamega.megasena.runner;

import java.util.HashSet;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.ExcludedGame;
import com.bolaodamega.megasena.domain.Game;
import com.bolaodamega.megasena.domain.HandleGame;
import com.bolaodamega.megasena.domain.MineGame;
import com.bolaodamega.megasena.repository.ExcludedGameRepository;
import com.bolaodamega.megasena.repository.HandleGameRepository;
import com.bolaodamega.megasena.repository.MineGameRepository;
import com.bolaodamega.megasena.roles.NumberGroupSequentialRole;
import com.bolaodamega.megasena.roles.NumbersFoldedRole;
import com.bolaodamega.megasena.roles.NumbersGreaterThanThirtyRole;
import com.bolaodamega.megasena.roles.NumbersInQuadrantRole;
import com.bolaodamega.megasena.roles.NumbersInTwoColumnRole;
import com.bolaodamega.megasena.roles.NumbersInTwoRowRole;
import com.bolaodamega.megasena.roles.NumbersLateralRole;
import com.bolaodamega.megasena.roles.NumbersLessAndEqualsThirtyRole;
import com.bolaodamega.megasena.roles.NumbersOddsAndEvenRole;
import com.bolaodamega.megasena.roles.NumbersPrimeRole;
import com.bolaodamega.megasena.roles.NumbersSameColumnRole;
import com.bolaodamega.megasena.roles.NumbersSameRowRole;
import com.bolaodamega.megasena.roles.NumbersSequentialRole;
import com.bolaodamega.megasena.roles.Role;
import com.bolaodamega.megasena.service.StatisticsServiceBean;

@Order(value = 30)
@Controller
public class MinerGameRunner implements CommandLineRunner {
    
    @Autowired
    private MineGameRepository mineGameRepository;
    
    @Autowired
    private ExcludedGameRepository excludedGameRepository;
    
    @Autowired
    private HandleGameRepository handleGameRepository;
    
    @Autowired
    private StatisticsServiceBean statisticsServiceBean;

    private static final Logger LOG = Logger.getLogger(MinerGameRunner.class);

    private Set<Role> roles = new HashSet<>();
    
    public MinerGameRunner() {
    	roles.add(new NumbersSequentialRole());
        roles.add(new NumbersOddsAndEvenRole());
        roles.add(new NumbersSameRowRole());
        roles.add(new NumbersSameColumnRole());
        roles.add(new NumbersLateralRole());
        roles.add(new NumbersInQuadrantRole());
        roles.add(new NumbersInTwoRowRole());
        roles.add(new NumbersInTwoColumnRole());
        roles.add(new NumberGroupSequentialRole());
        roles.add(new NumbersLessAndEqualsThirtyRole());
        roles.add(new NumbersGreaterThanThirtyRole());
        roles.add(new NumbersPrimeRole());
        roles.add(new NumbersFoldedRole());
    }

    private boolean miner(MineGame game) {
        LOG.info("VALIDATING " + game);
        for (Role role : roles) {
            boolean isInvalid = role.validate(game);
            if (isInvalid) {
                LOG.info("INVALID " + game);
                handleInvalidGame(game, role);
            }
            return isInvalid;
        }
        return false;
    }

    private void handleInvalidGame(MineGame game, Role role) {
    	try {
	        LOG.info("SAVING EXCLUDED " + game);
	        ExcludedGame newGame = new ExcludedGame();
	        newGame.setNumber01(game.getNumber01());
	        newGame.setNumber02(game.getNumber02());
	        newGame.setNumber03(game.getNumber03());
	        newGame.setNumber04(game.getNumber04());
	        newGame.setNumber05(game.getNumber05());
	        newGame.setNumber06(game.getNumber06());
	        newGame.setRole(role);
	        excludedGameRepository.save(newGame);
	        LOG.info("EXCLUDING " + game);
	        mineGameRepository.deleteNumber((Game) game);
    	} catch (Exception ex) {
    		LOG.info("SAVING HANDLED " + game);
    		LOG.error("ERROR DURING MINE GAME: " + ex);
	        HandleGame handleGame = new HandleGame();
	        handleGame.setNumber01(game.getNumber01());
	        handleGame.setNumber02(game.getNumber02());
	        handleGame.setNumber03(game.getNumber03());
	        handleGame.setNumber04(game.getNumber04());
	        handleGame.setNumber05(game.getNumber05());
	        handleGame.setNumber06(game.getNumber06());
	        handleGame.setRole(role);
	        handleGameRepository.save(handleGame);
    	}
    }

    public void start() {
        final int pageSize = 10000;
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
        if (EnableRunner.MINER_GAME) {
        	LOG.info("STARTED");
        	updateStatistics();
            start();
            updateStatistics();
            LOG.info("FINISHED");
		}
    }

	private void updateStatistics() {
		statisticsServiceBean.update();
	}

}
