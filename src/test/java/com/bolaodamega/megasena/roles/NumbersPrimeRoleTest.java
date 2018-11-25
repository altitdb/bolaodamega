package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can't be more than three primes.
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

	private Role role = new NumbersPrimeRole();
	
	@Test
	public void shoudShowValidWithOnePrime() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(4);
        game.setNumber03(10);
        game.setNumber04(12);
        game.setNumber05(24);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValidWithTwoPrimes() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(10);
        game.setNumber04(12);
        game.setNumber05(24);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValidWithThreePrimes() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(5);
        game.setNumber04(12);
        game.setNumber05(24);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValidWithOnePrimeBeginning() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(4);
        game.setNumber03(10);
        game.setNumber04(12);
        game.setNumber05(24);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValidWithOnePrimeEnd() {
		Game game = new Game();
        game.setNumber01(4);
        game.setNumber02(6);
        game.setNumber03(10);
        game.setNumber04(12);
        game.setNumber05(24);
        game.setNumber06(59);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
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
        assertFalse(result);
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
        assertFalse(result);
	}
	
	@Test
	public void shoudShowInvalidTestingAllPrimesFirstSequence() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(5);
        game.setNumber04(7);
        game.setNumber05(58);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowInvalidTestingAllPrimesSecondSequence() {
		Game game = new Game();
        game.setNumber01(11);
        game.setNumber02(13);
        game.setNumber03(17);
        game.setNumber04(19);
        game.setNumber05(58);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowInvalidTestingAllPrimesThirdSequence() {
		Game game = new Game();
        game.setNumber01(23);
        game.setNumber02(29);
        game.setNumber03(31);
        game.setNumber04(37);
        game.setNumber05(58);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowInvalidTestingAllPrimesFourthSequence() {
		Game game = new Game();
        game.setNumber01(41);
        game.setNumber02(43);
        game.setNumber03(47);
        game.setNumber04(53);
        game.setNumber05(58);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowInvalidTestingAllPrimesFifthSequence() {
		Game game = new Game();
        game.setNumber01(10);
        game.setNumber02(43);
        game.setNumber03(47);
        game.setNumber04(53);
        game.setNumber05(59);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertFalse(result);
	}
}
