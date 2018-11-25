package com.bolaodamega.megasena.roles;

import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersSequentialRole implements Role {

    @Override
	public boolean validate(Game game) {

		List<Integer> numbers = game.getNumbers();

		int i = 0;
		int sequenceCounter = 0;
		while (i < 5) {
			Integer actual = numbers.get(i);
			Integer next = numbers.get(i + 1);

			if (next == (actual + 1)) {
				sequenceCounter++;
			} else {
				sequenceCounter = 0;
			}
			i++;
			if (sequenceCounter > 1) {
				return true;
			}
		}
		return false;
	}

    @Override
    public int value() {
        return 1;
    }

}