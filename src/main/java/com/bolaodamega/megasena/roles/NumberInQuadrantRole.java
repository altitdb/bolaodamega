package com.bolaodamega.megasena.roles;

import java.util.Arrays;
import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumberInQuadrantRole implements Role {

	@Override
	public boolean validate(Game game) {
		List<Integer> numbers = game.getNumbers();
		Integer quadrantCount[] = new Integer[4];
		Arrays.fill(quadrantCount, 0);
		for(Integer number : numbers){
			int column = (number + 10) % 10;
			if (number < 31) {
				if (column > 0 && column < 6) {
					quadrantCount[0]++;
				} else {
					quadrantCount[1]++;
				}
			} else {
				if (column > 0 && column < 6) {
					quadrantCount[2]++;
				} else {
					quadrantCount[3]++;
				}
			}
		}
		for(Integer quadrant : quadrantCount){
			if (quadrant > 4) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int value() {
		return 6;
	}

}
