package com.bolaodamega.megasena.roles;

import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersOddsAndEvenRole implements Role{

	@Override
	public boolean validate(Game game) {
		List<Integer> numbers = game.getNumbers();
		int evens = 0;
		int odds = 0;
		for (Integer number : numbers) {
			if (number % 2 == 0) {
				evens++;
			} else {
				odds++;
			}
		}
		if (evens > 4 || odds > 4) {
			return true;
		}
		return false;
	}

	@Override
	public int value() {
		return 2;
	}

}
