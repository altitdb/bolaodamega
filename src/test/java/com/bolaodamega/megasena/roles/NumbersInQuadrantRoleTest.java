package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can't be in only a quadrant until fourth times
 * 
 * Quadrant 01: 1, 2, 3, 4, 5, 11, 12, 13, 14, 15, 21, 22, 23, 24, 25
 * Quadrant 02: 6, 7, 8, 9, 10, 16, 17, 18, 19, 20, 26, 27, 28, 29, 30
 * Quadrant 03: 31, 32, 33, 34, 35, 41, 42, 43, 44, 45, 51, 52, 53, 54, 55
 * Quadrant 04: 36, 37, 38, 39, 40, 46, 47, 48, 49, 50, 56, 57, 58, 59, 60
 * @author ALM
 *
 */
public class NumbersInQuadrantRoleTest {

	private Role role = new NumbersInQuadrantRole();
	
	@Test
	public void shoudShowInvalidFirstQuadrant() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(4);
        game.setNumber03(13);
        game.setNumber04(15);
        game.setNumber05(21);
        game.setNumber06(25);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidSecondQuadrant() {
		Game game = new Game();
        game.setNumber01(6);
        game.setNumber02(10);
        game.setNumber03(16);
        game.setNumber04(20);
        game.setNumber05(26);
        game.setNumber06(30);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidThirdQuadrant() {
		Game game = new Game();
        game.setNumber01(31);
        game.setNumber02(35);
        game.setNumber03(43);
        game.setNumber04(44);
        game.setNumber05(51);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidFourthQuadrant() {
		Game game = new Game();
        game.setNumber01(36);
        game.setNumber02(38);
        game.setNumber03(47);
        game.setNumber04(49);
        game.setNumber05(55);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidFirstQuadrantWithFiveNumber() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(4);
        game.setNumber03(13);
        game.setNumber04(15);
        game.setNumber05(21);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidSecondQuadrantWithFiveNumber() {
		Game game = new Game();
        game.setNumber01(4);
        game.setNumber02(10);
        game.setNumber03(16);
        game.setNumber04(20);
        game.setNumber05(26);
        game.setNumber06(30);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidThirdQuadrantWithFiveNumber() {
		Game game = new Game();
        game.setNumber01(31);
        game.setNumber02(35);
        game.setNumber03(43);
        game.setNumber04(49);
        game.setNumber05(51);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidFourthQuadrantWithFiveNumber() {
		Game game = new Game();
        game.setNumber01(35);
        game.setNumber02(38);
        game.setNumber03(47);
        game.setNumber04(49);
        game.setNumber05(56);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValid() {
		Game game = new Game();
        game.setNumber01(13);
        game.setNumber02(23);
        game.setNumber03(26);
        game.setNumber04(30);
        game.setNumber05(42);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertFalse(result);
	}
}
