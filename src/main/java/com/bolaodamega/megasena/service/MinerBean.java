package com.bolaodamega.megasena.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.MineGame;
import com.bolaodamega.megasena.repository.MineGameRepository;
import com.bolaodamega.megasena.roles.Role;
import com.bolaodamega.megasena.roles.SixNumbersSequentialRole;

@Controller
public class MinerBean implements CommandLineRunner {
    
    @Autowired
    private MineGameRepository mineGameRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOG = Logger.getLogger(MinerBean.class);

    private Set<Role> roles = new HashSet<Role>();

    private boolean miner(MineGame game) {
        LOG.debug("VALIDATING " + game);
        roles.add(new SixNumbersSequentialRole());
        for (Role role : roles) {
            return role.validate(game);
        }
        return false;
    }

    private void removeGame(MineGame game) {

    }

    public void start() {
        final int pageSize = 1000;
        int start = 0;
        Slice<MineGame> mineGameStream;
        do {
            mineGameStream = mineGameRepository.findAllBy(new PageRequest(start, pageSize));
            for (MineGame mineGame : mineGameStream) {
                boolean isInvalid = miner(mineGame);
                if (isInvalid) {
                    LOG.info("INVALID " + mineGame);
                    removeGame(mineGame);
                } else {
                    start++;
                }
            }
            entityManager.clear();
        }while(mineGameStream.hasNext());
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
