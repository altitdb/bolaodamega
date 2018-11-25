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
public class NumbersLateralRoleTest {

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
	public void shoudShowInvalidWithThreeNumbersFirstLine() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(3);
        game.setNumber03(5);
        game.setNumber04(22);
        game.setNumber05(27);
        game.setNumber06(36);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbersLastLine() {
		Game game = new Game();
        game.setNumber01(13);
        game.setNumber02(18);
        game.setNumber03(32);
        game.setNumber04(52);
        game.setNumber05(57);
        game.setNumber06(59);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbersFirstColumn() {
		Game game = new Game();
        game.setNumber01(11);
        game.setNumber02(15);
        game.setNumber03(21);
        game.setNumber04(33);
        game.setNumber05(41);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbersLastColumn() {
		Game game = new Game();
        game.setNumber01(14);
        game.setNumber02(20);
        game.setNumber03(25);
        game.setNumber04(30);
        game.setNumber05(46);
        game.setNumber06(50);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbersMiddleLeft() {
		Game game = new Game();
        game.setNumber01(4);
        game.setNumber02(15);
        game.setNumber03(21);
        game.setNumber04(34);
        game.setNumber05(47);
        game.setNumber06(52);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbersMiddleRight() {
		Game game = new Game();
        game.setNumber01(6);
        game.setNumber02(17);
        game.setNumber03(23);
        game.setNumber04(40);
        game.setNumber05(42);
        game.setNumber06(57);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbersMiddleUp() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(13);
        game.setNumber03(31);
        game.setNumber04(35);
        game.setNumber05(45);
        game.setNumber06(50);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidWithThreeNumbersMiddleDown() {
		Game game = new Game();
        game.setNumber01(13);
        game.setNumber02(26);
        game.setNumber03(30);
        game.setNumber04(41);
        game.setNumber05(47);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidOnCorners() {
		Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(10);
        game.setNumber03(14);
        game.setNumber04(47);
        game.setNumber05(51);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
	}
	
	@Test
	public void shoudShowValidLines() {
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
	
	@Test
	public void shoudShowValidColumns() {
		Game game = new Game();
        game.setNumber01(11);
        game.setNumber02(13);
        game.setNumber03(18);
        game.setNumber04(27);
        game.setNumber05(29);
        game.setNumber06(50);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowValidFirstLine() {
		Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(5);
        game.setNumber03(13);
        game.setNumber04(24);
        game.setNumber05(36);
        game.setNumber06(42);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowValidLastLine() {
		Game game = new Game();
        game.setNumber01(12);
        game.setNumber02(26);
        game.setNumber03(33);
        game.setNumber04(44);
        game.setNumber05(52);
        game.setNumber06(58);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowValidFirstColumn() {
		Game game = new Game();
        game.setNumber01(11);
        game.setNumber02(24);
        game.setNumber03(33);
        game.setNumber04(38);
        game.setNumber05(41);
        game.setNumber06(45);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	@Test
	public void shoudShowValidLastColumn() {
		Game game = new Game();
        game.setNumber01(13);
        game.setNumber02(20);
        game.setNumber03(33);
        game.setNumber04(40);
        game.setNumber05(42);
        game.setNumber06(49);
        boolean result = role.validate(game);
        assertFalse(result);
	}
	
	
}
