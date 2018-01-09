package com.bolaodamega.megasena.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.RaffledGame;
import com.bolaodamega.megasena.domain.Statistics;
import com.bolaodamega.megasena.dto.StatisticsDTO;
import com.bolaodamega.megasena.repository.ExcludedGameRepository;
import com.bolaodamega.megasena.repository.MineGameRepository;
import com.bolaodamega.megasena.repository.RaffledGameRepository;
import com.bolaodamega.megasena.repository.StatisticsRepository;

@Order(value = 2)
@Controller
public class StatisticsBean implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(StatisticsBean.class);

	@Autowired
	private StatisticsRepository statisticsRepository;
	@Autowired
	private MineGameRepository mineGameRepository;
	@Autowired
	private ExcludedGameRepository excludedGameRepository;
	@Autowired
	private RaffledGameRepository raffledGameRepository;

	@Override
	public void run(String... arg0) throws Exception {
		LOG.info("STARTED");
		start();
		LOG.info("FINISHED");
	}

	private void start() {
		amountGames();
		amountAvailableGames();
		amountExcludedGames();
		amountRaffledGames();
		amountNumbers();
	}

	private void amountNumbers() {
		Map<Integer, Integer> total = countNumberStatistics();
		saveNumberStatistics(total);
	}

	private Map<Integer, Integer> countNumberStatistics() {
		List<RaffledGame> raffledsGame = raffledGameRepository.findAll();
		Map<Integer, Integer> total = new HashMap<>();
		for (RaffledGame raffledGame : raffledsGame) {
			sum(total, raffledGame);
		}
		return total;
	}

	private void saveNumberStatistics(Map<Integer, Integer> total) {
		for (Entry<Integer, Integer> entry : total.entrySet()) {
			Statistics statistics = new Statistics();
			statistics.setId(entry.getKey() + 4);
			statistics.setDescription("Total Sorteado do Número " + entry.getKey());
			statistics.setValue(entry.getValue().longValue());
			statisticsRepository.save(statistics);
		}
	}

	private void sum(Map<Integer, Integer> total, RaffledGame raffledGame) {
		for (Integer number : raffledGame.getNumbers()) {
			if (total.get(number) == null) {
				total.put(number, 1);
			} else {
				total.put(number, total.get(number) + 1);
			}
		}
	}

	private void amountRaffledGames() {
		Statistics statistics = new Statistics();
		statistics.setId(4);
		statistics.setDescription("Total de Sorteios");
		Long total = raffledGameRepository.count();
		statistics.setValue(total);
		statisticsRepository.save(statistics);
	}

	private void amountExcludedGames() {
		Statistics statistics = new Statistics();
		statistics.setId(3);
		statistics.setDescription("Total de Jogos Excluídos");
		Long total = excludedGameRepository.count();
		statistics.setValue(total);
		statisticsRepository.save(statistics);
	}

	private void amountAvailableGames() {
		Statistics statistics = new Statistics();
		statistics.setId(2);
		statistics.setDescription("Total de Jogos Disponíveis");
		Long total = mineGameRepository.count();
		statistics.setValue(total);
		statisticsRepository.save(statistics);
	}

	private void amountGames() {
		Statistics statistics = new Statistics();
		statistics.setId(1);
		statistics.setDescription("Total de Jogos");
		statistics.setValue(50063860L);
		statisticsRepository.save(statistics);
	}

	public List<StatisticsDTO> findAll() {
		List<Statistics> allStatistics = statisticsRepository.findAll();
		List<StatisticsDTO> response = new ArrayList<>();
		allStatistics.stream().forEach(
				item -> response.add(new StatisticsDTO(item.getDescription(), item.getValue(), item.getLastUpdate())));
		return response;
	}
}
