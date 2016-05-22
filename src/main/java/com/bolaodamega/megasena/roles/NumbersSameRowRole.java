package com.bolaodamega.megasena.roles;

import java.util.Arrays;
import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersSameRowRole implements Role {

    @Override
    public boolean validate(Game game) {
    	List<Integer> numbers = game.getNumbers();
    	Integer rows[] = new Integer[6];
    	Arrays.fill(rows, 0, 6, 0);

		for (Integer number : numbers) {
			boolean find = false;
			Integer rowNumber = 0;
			Integer rowLimit = (rowNumber + 1) * 10;
			while(!find && rowLimit < 61){
				if (number <= rowLimit) {
					rows[rowNumber]++;
					find = true;
				}
				rowNumber++;
				rowLimit = (rowNumber + 1) * 10;
			}
		}
		
		for (Integer row : rows) {
			if (row > 3) {
				return true;
			}
		}
        return false;
    }

    @Override
    public int value() {
        return 3;
    }

}
