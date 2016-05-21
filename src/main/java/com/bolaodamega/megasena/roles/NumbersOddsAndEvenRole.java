package com.bolaodamega.megasena.roles;

import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersOddsAndEvenRole implements Role{

	@Override
	public boolean validate(Game game) {
		List<Integer> numbers = game.getNumbers();
		int even = 0;
		int odd = 0;
		int i = 0;
		while (i < 6) {
			int number = numbers.get(i);
			if (number % 2 == 0) {
				even++;
			} else {
				odd++;
			}
			if (i > 4 && (even > 4 || odd > 4)) {
				return true;
			}
			i++;
		}
		return false;
	}

	@Override
	public int value() {
		return 4;
	}

}
