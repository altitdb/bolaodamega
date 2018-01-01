package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can't be more than four primes.
 * Primes: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59
 * 
 * Example 01 (Correct): 1, 2, 3, 10, 24, 54
 * Example 02 (Correct): 5, 7, 10, 11, 24, 32
 * Example 03 (Incorrect): 3, 5, 7, 11, 47, 48
 * Example 04 (Incorrect): 17, 19, 23, 29, 31, 41
 * @author ALM
 *
 */
public class NumbersPrimeRoleTest {

	private Role role = new NumberPrimeRole();
	
	@Test
	public void shoudShowInvalidWithFourPrimes() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(5);
        game.setNumber04(7);
        game.setNumber05(24);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowInvalidWithFivePrimes() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(5);
        game.setNumber04(7);
        game.setNumber05(19);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidPrimes() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(5);
        game.setNumber04(7);
        game.setNumber05(19);
        game.setNumber06(59);
        boolean result = role.validate(game);
        assertTrue(result);
	}
}
