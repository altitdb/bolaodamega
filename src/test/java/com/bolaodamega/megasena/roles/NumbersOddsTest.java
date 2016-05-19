package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;
/**
 * The numbers only can to have four numbers odds in maximum
 * Example 01 (Incorrect): 2, 4, 6, 8, 10, 12
 * Example 02 (Incorrect): 2, 4, 6, 8, 10, 35
 * Example 03 (Incorrect): 2, 5, 6, 7, 10, 20
 * Example 04 (Correct): 2, 4, 6, 29, 41, 55
 * Example 05 (Correct): 2, 5, 6, 9, 10, 55
 * @author ALM
 *
 */
public class NumbersOddsTest {

	private Role role = new NumbersOddsRole();
	
	@Test
	public void shoudShowInvalidForSixNumberOdds() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(4);
        game.setNumber03(6);
        game.setNumber04(8);
        game.setNumber05(10);
        game.setNumber06(12);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidForFiveNumberOddsInTheBegin() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(4);
        game.setNumber03(6);
        game.setNumber04(8);
        game.setNumber05(10);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidForFiveNumberOddsInTheEnd() {
		Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(4);
        game.setNumber03(6);
        game.setNumber04(8);
        game.setNumber05(10);
        game.setNumber06(12);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValidInSequence() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(4);
        game.setNumber03(6);
        game.setNumber04(9);
        game.setNumber05(11);
        game.setNumber06(13);
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
