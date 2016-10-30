package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can not have values less or equal thirty.
 * 
 * Example 01 (Incorrect): 1, 2, 3, 4, 5, 6
 * Example 02 (Incorrect): 1, 2, 3, 11, 12, 13
 * Example 03 (Correct): 30, 31, 32, 45, 46, 47
 * Example 03 (Correct): 7, 8, 35, 36, 46, 47
 * @author ALM
 *
 */
public class NumbersLessAndEqualsThirtyRoleTest {

	private Role role = new NumbersLessAndEqualsThirtyRole();

	@Test
	public void shouldShowInvalidGroupSequenceTwoNumbers() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(8);
		game.setNumber04(9);
		game.setNumber05(18);
		game.setNumber06(30);
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
		Assert.assertFalse(isInvalid);
	}
	
}
