package com.bolaodamega.megasena.roles;

import com.bolaodamega.megasena.domain.Game;

public class NumbersPrimeRole implements Role {

	@Override
	public boolean validate(Game game) {
		return false;
	}

	@Override
	public int value() {
		return 12;
	}

}