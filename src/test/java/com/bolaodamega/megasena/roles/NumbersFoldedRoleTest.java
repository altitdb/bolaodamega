package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers only can have one folded number (11, 22, 33, 44, 55).
 * 
 * Example 01 (Incorrect): 1, 2, 8, 9, 11, 22 
 * Example 02 (Correct): 1, 2, 3, 8, 11, 20
 * 
 * @author ALM
 *
 */
public class NumbersFoldedRoleTest {

	private Role role = new NumbersFoldedRole();

	@Test
	public void shouldShowInvalidGroupSequenceTwoNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(8);
		game.setNumber04(9);
		game.setNumber05(11);
		game.setNumber06(22);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidGroupSequenceThreeFoldedNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(8);
		game.setNumber04(9);
		game.setNumber05(21);
		game.setNumber06(22);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidGroupSequenceTwoFoldedNumbersSeparated() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(3);
		game.setNumber03(8);
		game.setNumber04(15);
		game.setNumber05(50);
		game.setNumber06(51);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidGroupSequenceSixAndNoneNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(4);
		game.setNumber05(5);
		game.setNumber06(11);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidGroupSequenceOneFoldedNumbersInTheBeginning() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(6);
		game.setNumber03(8);
		game.setNumber04(15);
		game.setNumber05(50);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void shouldShowValidGroupSequenceOneFoldedNumbersInTheMiddle() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(10);
		game.setNumber03(17);
		game.setNumber04(18);
		game.setNumber05(53);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void shouldShowValidGroupSequenceNoFoldedNumbers() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(10);
		game.setNumber03(17);
		game.setNumber04(20);
		game.setNumber05(53);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void shouldShowValidGroupSequenceOneFoldedNumbersInTheEnd() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(10);
		game.setNumber03(17);
		game.setNumber04(32);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}

}
