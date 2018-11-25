package com.bolaodamega.megasena.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.MineGame;
import com.bolaodamega.megasena.dto.GameBaseDTO;
import com.bolaodamega.megasena.dto.GameStatusDTO;
import com.bolaodamega.megasena.dto.NextGameDTO;
import com.bolaodamega.megasena.repository.MineGameRepository;

@Controller
public class GameStatusServiceBean {

	private static final int FIRST_NUMBER_RESPONSE = 0;
	private static final int FIRST_NUMBER = 1;
	private static final int FIRST_PAGE = 0;
	private static final Logger LOG = Logger.getLogger(GameStatusServiceBean.class);

	@Autowired
	private MineGameRepository mineGameRepository;
	
	public GameStatusDTO getStatus(GameBaseDTO gameBase) {
		LOG.info("Finding " + gameBase);
		MineGame mineGame = new MineGame();
		mineGame.setNumber01(gameBase.getNumber01());
		mineGame.setNumber02(gameBase.getNumber02());
		mineGame.setNumber03(gameBase.getNumber03());
		mineGame.setNumber04(gameBase.getNumber04());
		mineGame.setNumber05(gameBase.getNumber05());
		mineGame.setNumber06(gameBase.getNumber06());
		Example<MineGame> example = Example.<MineGame>of(mineGame);
		Boolean available = mineGameRepository.exists(example);
		return new GameStatusDTO(gameBase, available);
	}

	public List<GameBaseDTO> getGames(NextGameDTO nextGame) {
		MineGame mineGame = new MineGame();
		mineGame.setNumber01(nextGame.getNumber01());
		mineGame.setNumber02(nextGame.getNumber02());
		mineGame.setNumber03(nextGame.getNumber03());
		mineGame.setNumber04(nextGame.getNumber04());
		mineGame.setNumber05(nextGame.getNumber05());
		mineGame.setNumber06(nextGame.getNumber06());
		Page<MineGame> pageGames = mineGameRepository.findAll(mineGame, new PageRequest(FIRST_PAGE, nextGame.getAmount() + FIRST_NUMBER));
		List<MineGame> games = pageGames.getContent();
		List<GameBaseDTO> response = new ArrayList<>();
		games.stream().forEach(
				item -> response.add(convert(item)));
		response.remove(FIRST_NUMBER_RESPONSE);
		return response;
	}

	private GameBaseDTO convert(MineGame item) {
		GameBaseDTO gameBase = new GameBaseDTO();
		gameBase.setNumber01(item.getNumber01());
		gameBase.setNumber02(item.getNumber02());
		gameBase.setNumber03(item.getNumber03());
		gameBase.setNumber04(item.getNumber04());
		gameBase.setNumber05(item.getNumber05());
		gameBase.setNumber06(item.getNumber06());
		return gameBase;
	}

}