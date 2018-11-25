package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can not have values less or equal thirty.
 * 
 * Example 01 (Correct): 1, 2, 3, 4, 5, 6
 * Example 02 (Correct): 1, 2, 3, 11, 12, 13
 * Example 03 (Incorrect): 31, 32, 33, 45, 46, 47
 * Example 04 (Incorrect): 31, 33, 35, 36, 46, 47
 * @author ALM
 *
 */
public class NumbersGreaterThanThirtyRoleTest {

	private Role role = new NumbersGreaterThanThirtyRole();

	@Test
	public void shouldShowValidNumber() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(8);
		game.setNumber04(9);
		game.setNumber05(18);
		game.setNumber06(41);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidGreaterThanThirty() {
		Game game = new Game();
		game.setNumber01(31);
		game.setNumber02(32);
		game.setNumber03(33);
		game.setNumber04(34);
		game.setNumber05(45);
		game.setNumber06(50);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
}
