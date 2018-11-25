package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers only can have three numbers in sequential order.
 * 
 * Example 01 (Incorrect): 1, 2, 3, 4, 5, 6
 * Example 02 (Incorrect): 1, 2, 3, 11, 12, 13
 * Example 03 (Incorrect): 30, 31, 32, 45, 46, 47
 * Example 03 (Incorrect): 7, 8, 35, 36, 46, 47
 * Example 04 (Incorrect): 1, 2, 8, 9, 32, 47
 * Example 05 (Correct): 1, 2, 3, 8, 11, 20
 * @author ALM
 *
 */
public class NumbersGroupSequentialRoleTest {

	private Role role = new NumberGroupSequentialRole();

	@Test
	public void shouldShowInvalidGroupSequenceTwoNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(8);
		game.setNumber04(9);
		game.setNumber05(31);
		game.setNumber06(32);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidGroupSequenceThreeNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(30);
		game.setNumber05(31);
		game.setNumber06(32);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidTwoSequencesBeginAndEnd() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(15);
		game.setNumber04(27);
		game.setNumber05(42);
		game.setNumber06(43);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidTwoSequencesMidleAndEnd() {
		Game game = new Game();
		game.setNumber01(7);
		game.setNumber02(14);
		game.setNumber03(26);
		game.setNumber04(27);
		game.setNumber05(42);
		game.setNumber06(43);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidTwoSequencesBeginAndMidle() {
		Game game = new Game();
		game.setNumber01(7);
		game.setNumber02(8);
		game.setNumber03(26);
		game.setNumber04(27);
		game.setNumber05(42);
		game.setNumber06(51);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidTwoSequencesMidle() {
		Game game = new Game();
		game.setNumber01(7);
		game.setNumber02(13);
		game.setNumber03(14);
		game.setNumber04(27);
		game.setNumber05(28);
		game.setNumber06(51);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidTwoSequencesThreeAndTwoBegin() {
		Game game = new Game();
		game.setNumber01(7);
		game.setNumber02(8);
		game.setNumber03(9);
		game.setNumber04(15);
		game.setNumber05(16);
		game.setNumber06(29);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidTwoSequencesThreeAndTwoEnd() {
		Game game = new Game();
		game.setNumber01(7);
		game.setNumber02(13);
		game.setNumber03(14);
		game.setNumber04(15);
		game.setNumber05(28);
		game.setNumber06(29);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidTwoSequencesThreeAndTwoWithMiddleGap() {
		Game game = new Game();
		game.setNumber01(7);
		game.setNumber02(8);
		game.setNumber03(9);
		game.setNumber04(15);
		game.setNumber05(28);
		game.setNumber06(29);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowValidGroupSequenceTwoAndFourNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(19);
		game.setNumber04(30);
		game.setNumber05(41);
		game.setNumber06(52);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidGroupSequenceFourAndTwoNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(4);
		game.setNumber05(41);
		game.setNumber06(52);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidGroupSequenceSixAndNoneNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(4);
		game.setNumber05(5);
		game.setNumber06(6);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}

}
