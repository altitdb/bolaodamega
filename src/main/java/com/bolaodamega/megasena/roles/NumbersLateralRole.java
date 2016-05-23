package com.bolaodamega.megasena.roles;

import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersLateralRole implements Role {

	@Override
	public boolean validate(Game game) {
		List<Integer> numbers = game.getNumbers();
		int lateralCount = 0;
		for(Integer number : numbers){
			boolean invalidColumn = number % 10 < 2;
			boolean invalidRow = (number < 11 || number > 50);
			if(invalidRow || invalidColumn){
				lateralCount++;
				if(lateralCount > 2) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int value() {
		return 5;
	}

}
