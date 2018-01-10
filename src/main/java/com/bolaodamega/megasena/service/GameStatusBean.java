package com.bolaodamega.megasena.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bolaodamega.megasena.domain.GamePK;
import com.bolaodamega.megasena.dto.GameBaseDTO;
import com.bolaodamega.megasena.dto.GameStatusDTO;
import com.bolaodamega.megasena.repository.MineGameRepository;

@Controller
public class GameStatusBean {

	private static final Logger LOG = Logger.getLogger(GameStatusBean.class);

	@Autowired
	private MineGameRepository mineGameRepository;
	
	public GameStatusDTO getStatus(GameBaseDTO gameBase) {
		LOG.info("Finding " + gameBase);
		GamePK gamePK = new GamePK();
		gamePK.setNumber01(gameBase.getNumber01());
		gamePK.setNumber02(gameBase.getNumber02());
		gamePK.setNumber03(gameBase.getNumber03());
		gamePK.setNumber04(gameBase.getNumber04());
		gamePK.setNumber05(gameBase.getNumber05());
		gamePK.setNumber06(gameBase.getNumber06());
		Boolean available = mineGameRepository.exists(gamePK);
		return new GameStatusDTO(gameBase, available);
	}

}