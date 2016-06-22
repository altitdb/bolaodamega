package com.bolaodamega.megasena.roles;

import java.util.Arrays;
import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersInTwoRowRole implements Role {

    @Override
    public boolean validate(Game game) {
    	List<Integer> numbers = game.getNumbers();
    	int[] rows = new int[6];
    	Arrays.fill(rows, 0);
    	int rowsCount = 0;
    	for(Integer number : numbers){
    		for(int i = 0; i < 6; i++){
    			int rowLimit = (i + 1) * 10;
    			if(number <= rowLimit){
    				if(rows[i] == 0){
    					rows[i]++;
    					rowsCount++;
    				}
    				if(rowsCount > 2){
    					return false;
    				}
    				break;
    			}
    		}
    	}
        return true;
    }

    @Override
    public int value() {
        return 7;
    }

}
