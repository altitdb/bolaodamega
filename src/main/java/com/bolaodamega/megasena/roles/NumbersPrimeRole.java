package com.bolaodamega.megasena.roles;

import java.util.Arrays;
import java.util.List;

import com.bolaodamega.megasena.domain.Game;

public class NumbersPrimeRole implements Role {
	
	Integer primesPermited = 3; 
	List<Integer> primes = Arrays.asList(new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59});

	@Override
	public boolean validate(Game game) {
		Integer primesCounter = 0;
		
		for (Integer number : game.getNumbers()) {
			if (primes.contains(number)) {
				primesCounter++;
			}
			if (primesCounter > primesPermited) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public int value() {
		return 12;
	}

}
