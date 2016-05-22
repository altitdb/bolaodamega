package com.bolaodamega.megasena.roles;

import java.util.Arrays;
import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersSameColumn implements Role {

    @Override
    public boolean validate(Game game) {
    	List<Integer> numbers = game.getNumbers();
    	int columns[] = new int[10];
    	Arrays.fill(columns, 0);
    	for(Integer number : numbers){
    		int column = (number + 10)%10;
    		columns[column]++;
    		if(columns[column] > 3) return true;
    	}
        return false;
    }

    @Override
    public int value() {
        return 2;
    }

}
