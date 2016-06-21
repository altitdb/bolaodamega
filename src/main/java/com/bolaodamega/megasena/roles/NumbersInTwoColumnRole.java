package com.bolaodamega.megasena.roles;

import java.util.Arrays;
import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersInTwoColumnRole implements Role {

    @Override
    public boolean validate(Game game) {
    	List<Integer> numbers = game.getNumbers();
    	int columns[] = new int[10];
    	Arrays.fill(columns, 0);	
    	int columnCount = 0;
    	for(Integer number : numbers){
    		int column = (number + 10)%10;
    		if(columns[column] == 0) {
    			columns[column]++;
    			columnCount++;
    		}
    	}
    	if(columnCount < 3){
    		return true;
    	}
        return false;
    }

    @Override
    public int value() {
        return -1;
    }

}
