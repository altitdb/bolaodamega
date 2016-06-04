package com.bolaodamega.megasena.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jboss.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.RaffledGame;
import com.bolaodamega.megasena.repository.RaffledGameRepository;
import com.mysql.jdbc.StringUtils;

@Order(value = -1)
@Controller
public class ExtractRaffledGameBean implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(ExtractRaffledGameBean.class);
	private static final String FILE = "src/main/resources/D_MEGA.HTM";
	
	@Autowired
	private RaffledGameRepository raffledGameRepository;
	
	public void start() {
		delete();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
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

	private void delete() {
		raffledGameRepository.deleteAll();
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
					raffledGame.setNumber01(getInteger(gameIterator.next().text()));
					raffledGame.setNumber02(getInteger(gameIterator.next().text()));
					raffledGame.setNumber03(getInteger(gameIterator.next().text()));
					raffledGame.setNumber04(getInteger(gameIterator.next().text()));
					raffledGame.setNumber05(getInteger(gameIterator.next().text()));
					raffledGame.setNumber06(getInteger(gameIterator.next().text()));
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
		for (RaffledGame raffledGame : raffleds) {
			raffledGameRepository.save(raffledGame);
		}
	}

	private Integer getInteger(String value) {
		if (StringUtils.isNullOrEmpty(value)) {
			return null;
		}
		return Integer.valueOf(value);
	}
	
	private BigDecimal getBigDecimal(String value) {
		if (StringUtils.isNullOrEmpty(value)) {
			return null;
		}
		String newValue = value.replaceAll("\\.", "").replaceAll(",", ".");
		return new BigDecimal(newValue);
	}
	
	@Override
    public void run(String... arg0) throws Exception {
        LOG.info("STARTED");
        start();
        LOG.info("FINISHED");
    }

}
