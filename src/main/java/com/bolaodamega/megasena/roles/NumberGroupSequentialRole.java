package com.bolaodamega.megasena.roles;

import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumberGroupSequentialRole implements Role {

	@Override
	public boolean validate(Game game) {
		List<Integer> numbers = game.getNumbers();
		int sequentialCount = 0;
		for(int i = 1; i < numbers.size();){
			int actual = numbers.get(i);
			int before = numbers.get(i -1);
			if(actual == (before + 1)){
				sequentialCount++;
//				i++;
				while(i < numbers.size() && actual == (before +1)){
					actual = numbers.get(i);
					before = numbers.get(i -1);
					i++;
				}
			}else{
				i++;
			}
			if(sequentialCount > 1){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int value() {
		return -1;
	}

}
