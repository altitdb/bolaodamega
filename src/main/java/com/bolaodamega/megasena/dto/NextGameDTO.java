package com.bolaodamega.megasena.dto;

public class NextGameDTO extends GameBaseDTO {

	private static final int MINIMUM_AMOUNT = 1;
	private Integer amount;

	public NextGameDTO() {
	}
	
	public NextGameDTO(GameBaseDTO gameBase, Integer amount) {
		super.setNumber01(gameBase.getNumber01());
		super.setNumber02(gameBase.getNumber02());
		super.setNumber03(gameBase.getNumber03());
		super.setNumber04(gameBase.getNumber04());
		super.setNumber05(gameBase.getNumber05());
		super.setNumber06(gameBase.getNumber06());
		this.amount = amount;
	}

	public Integer getAmount() {
		if (amount == null) {
			return MINIMUM_AMOUNT;
		}
		return amount;
	}

}
