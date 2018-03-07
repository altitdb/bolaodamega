package com.bolaodamega.megasena.roles;

import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersFoldedRole implements Role {

	@Override
	public boolean validate(Game game) {
		List<Integer> numbers = game.getNumbers();
		
		Integer actual = 0;
		
		Integer next = 0;
		
		int count = 0;
		
		int foldedNumbersAcceptable = 1;
		
		for (int i = 0; i < numbers.size() - foldedNumbersAcceptable; i++) {

			actual = numbers.get(i);
			
			next = numbers.get(i + foldedNumbersAcceptable);
			
			if (actual.equals(next -foldedNumbersAcceptable)) {
				
				count++;
				
				i++;
			}
			
			if (count > foldedNumbersAcceptable) return false;
		}
		
		return true;
	}

	@Override
	public int value() {
		return 13;
	}

}
