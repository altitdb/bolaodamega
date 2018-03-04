package com.bolaodamega.megasena.dto;

import java.util.Date;

public class RaffledDTO {

	private Integer tenderNumber;
	private Date tenderDate;
	private GameBaseDTO game;

	public Integer getTenderNumber() {
		return tenderNumber;
	}

	public void setTenderNumber(Integer tenderNumber) {
		this.tenderNumber = tenderNumber;
	}
	
	public Date getTenderDate() {
		return tenderDate;
	}

	public void setTenderDate(Date tenderDate) {
		this.tenderDate = tenderDate;
	}

	public GameBaseDTO getGame() {
		return game;
	}

	public void setGame(GameBaseDTO game) {
		this.game = game;
	}

}
