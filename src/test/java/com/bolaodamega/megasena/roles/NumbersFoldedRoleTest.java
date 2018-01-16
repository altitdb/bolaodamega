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
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowValidGroupSequenceSixAndNoneNumbers() {
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

}
