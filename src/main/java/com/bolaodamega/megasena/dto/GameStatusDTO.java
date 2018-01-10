package com.bolaodamega.megasena.dto;

public class GameStatusDTO extends GameBaseDTO {

	private Boolean available;

	public GameStatusDTO() {
	}
	
	public GameStatusDTO(GameBaseDTO gameBase, Boolean available) {
		super.setNumber01(gameBase.getNumber01());
		super.setNumber02(gameBase.getNumber02());
		super.setNumber03(gameBase.getNumber03());
		super.setNumber04(gameBase.getNumber04());
		super.setNumber05(gameBase.getNumber05());
		super.setNumber06(gameBase.getNumber06());
		this.available = available;
	}

	public Boolean getAvailable() {
		return available;
	}

}
