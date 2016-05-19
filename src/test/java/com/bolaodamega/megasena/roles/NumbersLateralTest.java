package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can to have no maximum three number of lateral.
 * 
 * Lateral Numbers: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 20, 21, 30, 31, 40, 41,
 * 50, 51, 52, 53, 53, 54, 55, 56, 57, 58, 58, 60
 * 
 * @author ALM
 *
 */
public class NumbersLateralTest {

	private Role role = new NumbersLateralRole();

	@Test
	public void shoudShowInvalid() {
		Game game = new Game();
        game.setNumber01(5);
        game.setNumber02(6);
        game.setNumber03(10);
        game.setNumber04(21);
        game.setNumber05(52);
        game.setNumber06(56);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithFiveNumbers() {
		Game game = new Game();
        game.setNumber01(8);
        game.setNumber02(9);
        game.setNumber03(10);
        game.setNumber04(21);
        game.setNumber05(23);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithFourNumbers() {
		Game game = new Game();
        game.setNumber01(8);
        game.setNumber02(9);
        game.setNumber03(18);
        game.setNumber04(21);
        game.setNumber05(29);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbers() {
		Game game = new Game();
        game.setNumber01(8);
        game.setNumber02(9);
        game.setNumber03(18);
        game.setNumber04(27);
        game.setNumber05(29);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValid() {
		Game game = new Game();
        game.setNumber01(8);
        game.setNumber02(13);
        game.setNumber03(18);
        game.setNumber04(27);
        game.setNumber05(29);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertFalse(result);
	}
}
