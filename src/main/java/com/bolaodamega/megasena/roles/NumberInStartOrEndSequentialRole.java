package com.bolaodamega.megasena.roles;

import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumberInStartOrEndSequentialRole implements Role {

	@Override
	public boolean validate(Game game) {

		Integer[] positions = { 0, 3 };
		
		Integer[] positionValues = { 1, 58 };

		List<Integer> numbers = game.getNumbers();

		for (int i = 0; i < positions.length; i++) {
			
			Integer index = positions[i];

			if (positionValues[i].equals(numbers.get(index))) {
				
				if (isSequence(numbers, index)) return false;
			}
			
		}
			
		return true;
	}

	private boolean isSequence(List<Integer> numbers, int index) {

		for (int i = index; i < (index + 2); i++) {
			
			Integer numberActual = numbers.get(i);
			Integer numberNext = numbers.get(i + 1);

			if (!numberActual.equals(numberNext - 1))
				return false;

		}

		return true;
	}

	@Override
	public int value() {
		return 14;
	}

}
