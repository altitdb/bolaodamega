package com.bolaodamega.megasena.runner;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.MineGame;
import com.bolaodamega.megasena.repository.MineGameRepository;

@Order(value = 10)
@Controller
public class GenerateGameRunner implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(GenerateGameRunner.class);
	private List<MineGame> games = new ArrayList<>();
	@Autowired
	private MineGameRepository mineGameRepository;
	
	public void start() {
		LOG.info("START GENERATE NUMBERS");
		for (int number01 = 1; number01 <= 60; number01++) {
			for (int number02 = number01 + 1; number02 <= 60; number02++) {
				for (int number03 = number02 + 1; number03 <= 60; number03++) {
					for (int number04 = number03 + 1; number04 <= 60; number04++) {
						for (int number05 = number04 + 1; number05 <= 60; number05++) {
							for (int number06 = number05 + 1; number06 <= 60; number06++) {
								MineGame game = new MineGame();
								game.setNumber01(number01);
								game.setNumber02(number02);
								game.setNumber03(number03);
								game.setNumber04(number04);
								game.setNumber05(number05);
								game.setNumber06(number06);
								LOG.info("GENERATE " + game);
								save(game);
							}
						}
					}	
				}
			}	
		}
		LOG.info("END GENERATE NUMBERS");
		save();
		System.exit(0);
	}
	
	private void save(MineGame game) {
		games.add(game);
		if (games.size() == 1000) {
			save();
		}
	}

	private void save() {
		LOG.info("SAVING GAMES " + games);
		mineGameRepository.save(games);
		games.clear();
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (EnableRunner.GENERATE_GAME) {
			LOG.info("STARTED");
			start();
			LOG.info("FINISHED");
		}
	}

}
