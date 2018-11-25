package com.bolaodamega.megasena.runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.RaffledGame;
import com.bolaodamega.megasena.repository.ExcludedGameRepository;
import com.bolaodamega.megasena.repository.MineGameRepository;
import com.bolaodamega.megasena.repository.RaffledGameRepository;
import com.bolaodamega.megasena.service.StatisticsServiceBean;

@Order(value = 20)
@Controller
public class ExtractRaffledGameRunner implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ExtractRaffledGameRunner.class);
	private static final String FILE = "classpath:/D_MEGA.HTM";
	
	@Autowired
	private RaffledGameRepository raffledGameRepository;
	
	@Autowired
    private MineGameRepository mineGameRepository;
    
    @Autowired
    private ExcludedGameRepository excludedGameRepository;
	
	@Autowired
	private ResourceLoader loader;
	
	@Autowired
	private StatisticsServiceBean statisticsServiceBean;
	
	private void start() {
		clearDatabase();
		fillDatabase();
		updateDatabase();
		updateStatistics();
	}
	
	private void updateStatistics() {
		statisticsServiceBean.update();		
	}

	private void clearDatabase() {
		raffledGameRepository.deleteAll();
	}
	
	private void fillDatabase() {
		Resource resource = loader.getResource(FILE);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
			StringBuilder html = new StringBuilder();
			String sCurrentLine;
			
			while ((sCurrentLine = br.readLine()) != null) {
				html.append(sCurrentLine);
			}
				
			Document doc = Jsoup.parse(html.toString());
			Elements elements = doc.getElementsByTag("tr");
			extractGame(elements);
		} catch(IOException e) {
			LOG.error("ERROR IN PARSE HTML", e);
		} catch (ParseException e) {
			LOG.error("ERROR IN PARSE DATE OF HTML", e);
		}
	}
	
	private void updateDatabase() {
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
            		mineGameRepository.deleteNumber(raffledGame.getGame());
            		excludedGameRepository.deleteNumber(raffledGame.getGame());
            	} catch (EmptyResultDataAccessException erdae) {
            		LOG.debug(raffledGame + " ALREADY WAS DELETED");
            	}
            }
            start++;
        } while (raffledGameStream.hasNext());
    }

	private void extractGame(Elements elements) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Iterator<Element> gamesIterator = elements.iterator();
		gamesIterator.next();
		List<RaffledGame> raffleds = new ArrayList<>();
		RaffledGame raffledGame = null;
		while (gamesIterator.hasNext()) {
			Element next = gamesIterator.next();
			Elements gameElement = next.getElementsByTag("td");
			int size = gameElement.size();
			Iterator<Element> gameIterator = gameElement.iterator();
			if (size == 21) {
				if (raffledGame != null) {
					raffleds.add(raffledGame);
				}
				raffledGame = new RaffledGame();
				while (gameIterator.hasNext()) {
					raffledGame.setTenderNumber(getInteger(gameIterator.next().text()));
					raffledGame.setTenderDate(simpleDateFormat.parse(gameIterator.next().text()));
					List<Integer> numbers = new ArrayList<>();
					for (int i = 0; i < 6; i++) {
						numbers.add(getInteger(gameIterator.next().text()));
					}
					Collections.sort(numbers);
					raffledGame.setNumber01(numbers.get(0));
					raffledGame.setNumber02(numbers.get(1));
					raffledGame.setNumber03(numbers.get(2));
					raffledGame.setNumber04(numbers.get(3));
					raffledGame.setNumber05(numbers.get(4));
					raffledGame.setNumber06(numbers.get(5));
					raffledGame.setTaxRevenuesTotal(getBigDecimal(gameIterator.next().text()));
					raffledGame.setWinnersSixth(getInteger(gameIterator.next().text()));
					raffledGame.setCity(gameIterator.next().text());
					raffledGame.setState(gameIterator.next().text());
					raffledGame.setValueFourth(getBigDecimal(gameIterator.next().text()));
					raffledGame.setWinnersFifth(getInteger(gameIterator.next().text()));
					raffledGame.setValueFifth(getBigDecimal(gameIterator.next().text()));
					raffledGame.setWinnersFourth(getInteger(gameIterator.next().text()));
					raffledGame.setValuesSixth(getBigDecimal(gameIterator.next().text()));
					raffledGame.setAccumulated(gameIterator.next().text());
					raffledGame.setAccumulatedValue(getBigDecimal(gameIterator.next().text()));
					raffledGame.setEstimatedPrize(getBigDecimal(gameIterator.next().text()));
					raffledGame.setAccumulatedTurning(getBigDecimal(gameIterator.next().text()));
				}
			} else if (raffledGame != null) {
				String city = String.format("%s, %s", raffledGame.getCity(), gameIterator.next().text());
				raffledGame.setCity(city);
				String state = String.format("%s, %s", raffledGame.getState(), gameIterator.next().text());
				raffledGame.setState(state);
			}
		}
		raffleds.add(raffledGame);
		LOG.info("GAME TOTAL: " + raffleds.size());
		LOG.info("GAMES: " + raffleds);
		save(raffleds);
	}
	
	private void save(List<RaffledGame> raffleds) {
		raffledGameRepository.save(raffleds);
	}

	private Integer getInteger(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		return Integer.valueOf(value);
	}
	
	private BigDecimal getBigDecimal(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		String newValue = value.replaceAll("\\.", "").replaceAll(",", ".");
		return new BigDecimal(newValue);
	}
	
	@Override
    public void run(String... arg0) throws Exception {
		if (EnableRunner.RAFFLED_GAME) {
			LOG.info("STARTED");
			start();
			LOG.info("FINISHED");
		}
    }

}
