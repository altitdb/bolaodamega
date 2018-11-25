package com.bolaodamega.megasena.roles;

import com.bolaodamega.megasena.domain.Game;

public class NumbersLessAndEqualsThirtyRole implements Role {

	private static final int NUMBER_THIRTY = 30;

	@Override
	public boolean validate(Game game) {
		for (Integer number : game.getNumbers()) {
			if (number > NUMBER_THIRTY) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int value() {
		return 10;
	}

}
