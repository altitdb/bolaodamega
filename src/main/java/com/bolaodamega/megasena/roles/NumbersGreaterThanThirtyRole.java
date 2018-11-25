package com.bolaodamega.megasena.roles;

import com.bolaodamega.megasena.domain.Game;

public class NumbersGreaterThanThirtyRole implements Role {

	private static final int NUMBER_THIRTY = 30;

	@Override
	public boolean validate(Game game) {
		if (game.getNumber01() > NUMBER_THIRTY) {
			return true;
		}
		return false;
	}

	@Override
	public int value() {
		return 11;
	}

}
