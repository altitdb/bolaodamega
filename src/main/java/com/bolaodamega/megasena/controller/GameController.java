package com.bolaodamega.megasena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolaodamega.megasena.dto.GameBaseDTO;
import com.bolaodamega.megasena.dto.GameStatusDTO;
import com.bolaodamega.megasena.dto.NextGameDTO;
import com.bolaodamega.megasena.service.GameStatusBean;

@RestController
public class GameController {

	@Autowired
	private GameStatusBean gameStatusBean;
	
	@RequestMapping(value = "/api/v1/game/status", method = RequestMethod.POST)
	public GameStatusDTO getGameStatus(@RequestBody GameBaseDTO gameBase) {
		return gameStatusBean.getStatus(gameBase);
	}
	
	@RequestMapping(value = "/api/v1/game/next", method = RequestMethod.POST)
	public List<GameBaseDTO> getNextGame(@RequestBody NextGameDTO nextGame) {
		return gameStatusBean.getGames(nextGame);
	}
}
