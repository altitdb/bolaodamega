package com.bolaodamega.megasena.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.RaffledGame;
import com.bolaodamega.megasena.repository.MineGameRepository;
import com.bolaodamega.megasena.repository.RaffledGameRepository;

@Order(value = 1)
@Controller
public class MinerRaffledBean implements CommandLineRunner {
    
    @Autowired
    private RaffledGameRepository raffledGameRepository;
    
    @Autowired
    private MineGameRepository mineGameRepository;
    
    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOG = Logger.getLogger(MinerRaffledBean.class);

    public void start() {
        final int pageSize = 100;
        int start = 0;
        Slice<RaffledGame> raffledGameStream;
        do {
            LOG.debug("STARTING SEARCH IN " + start);
            raffledGameStream = raffledGameRepository.findAllBy(new PageRequest(start, pageSize));
            LOG.debug("TOTAL: " + raffledGameStream.getSize());
            for (RaffledGame raffledGame : raffledGameStream) {
            	LOG.debug("DELETING " + raffledGame);
            	try {
            		mineGameRepository.delete(raffledGame.getGamePk());
            	} catch (EmptyResultDataAccessException erdae) {
            		LOG.debug(raffledGame + " ALREADY WAS DELETED");
            	}
            }
            start++;
            entityManager.clear();
        } while (raffledGameStream.hasNext());
    }

    @Override
    public void run(String... arg0) throws Exception {
        LOG.info("STARTED");
        start();
        LOG.info("FINISHED");
    }

}
