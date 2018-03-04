package com.bolaodamega.megasena.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolaodamega.megasena.domain.RaffledGame;
import com.bolaodamega.megasena.dto.GameBaseDTO;
import com.bolaodamega.megasena.dto.RaffledDTO;
import com.bolaodamega.megasena.repository.RaffledGameRepository;

@Component
public class RaffledGameServiceBean {

	private static final int FIRST_GAME = 1;

	private static final int ONE_GAME = 1;

	private static final Logger LOG = Logger.getLogger(RaffledGameServiceBean.class);
	
	@Autowired
	private RaffledGameRepository raffledGameRepository;

	public RaffledDTO getLast() {
		RaffledGame raffled = raffledGameRepository.findTopByOrderByTenderNumberDesc();
		return createDto(raffled);
	}

	public RaffledDTO getNext(Integer tenderNumber) {
		LOG.debug("Finding next tenderNumber: " + tenderNumber);
		Integer tenderNumberCandidate = tenderNumber + ONE_GAME;
		Integer tenderNumberHandled = handleTenderNumber(tenderNumberCandidate);
		RaffledGame raffled = raffledGameRepository.findByTenderNumber(tenderNumberHandled);
		return createDto(raffled);
	}

	public RaffledDTO getPrevious(Integer tenderNumber) {
		LOG.debug("Finding previous tenderNumber: " + tenderNumber);
		Integer tenderNumberCandidate = tenderNumber - ONE_GAME;
		Integer tenderNumberHandled = handleTenderNumber(tenderNumberCandidate);
		RaffledGame raffled = raffledGameRepository.findByTenderNumber(tenderNumberHandled);
		return createDto(raffled);
	}

	private RaffledDTO createDto(RaffledGame raffled) {
		RaffledDTO dto = new RaffledDTO();
		dto.setTenderNumber(raffled.getTenderNumber());
		dto.setTenderDate(raffled.getTenderDate());
		dto.setGame(convert(raffled));
		return dto;
	}

	private Integer handleTenderNumber(Integer tenderNumber) {
		RaffledGame lastRaffled = raffledGameRepository.findTopByOrderByTenderNumberDesc();
		Integer lastTenderNumber = lastRaffled.getTenderNumber();
		if (tenderNumber >= lastTenderNumber) {
			return lastTenderNumber;
		} else if (tenderNumber < FIRST_GAME) {
			return FIRST_GAME;
		}
		return tenderNumber;
	}
	
	private GameBaseDTO convert(RaffledGame item) {
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
