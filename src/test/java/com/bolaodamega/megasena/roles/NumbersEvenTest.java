package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;
/**
 * The numbers only can to have four numbers even in maximum
 * Example 01 (Incorrect): 3, 5, 7, 9, 11, 13
 * Example 02 (Incorrect): 3, 5, 7, 10, 11, 13
 * Example 03 (Correct): 3, 6, 7, 10, 11, 13
 * Example 04 (Correct): 2, 4, 6, 29, 41, 55
 * Example 05 (Correct): 2, 5, 6, 9, 10, 55
 * @author ALM
 *
 */
public class NumbersEvenTest {

	private Role role = new NumbersEvenRole();
	
	@Test
	public void shoudShowInvalidForSixNumberEven() {
		Game game = new Game();
        game.setNumber01(3);
        game.setNumber02(5);
        game.setNumber03(7);
        game.setNumber04(9);
        game.setNumber05(11);
        game.setNumber06(13);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidForFiveNumberEvenInTheBegin() {
		Game game = new Game();
        game.setNumber01(3);
        game.setNumber02(5);
        game.setNumber03(7);
        game.setNumber04(9);
        game.setNumber05(11);
        game.setNumber06(50);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidForFiveNumberEvenInTheEnd() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(5);
        game.setNumber04(7);
        game.setNumber05(9);
        game.setNumber06(11);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValidInSequence() {
		Game game = new Game();
        game.setNumber01(3);
        game.setNumber02(5);
        game.setNumber03(7);
        game.setNumber04(9);
        game.setNumber05(14);
        game.setNumber06(18);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowValidOutOfSequence() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(5);
        game.setNumber03(6);
        game.setNumber04(9);
        game.setNumber05(11);
        game.setNumber06(12);
        boolean result = role.validate(game);
        assertFalse(result);
	}
}
