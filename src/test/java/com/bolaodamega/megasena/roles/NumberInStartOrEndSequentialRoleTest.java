package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers cannot starts with 1, 2, 3 or ends 58, 59, 60.
 * 
 * @author RLUIZ
 *
 */
public class NumberInStartOrEndSequentialRoleTest {

	private Role role = new NumberInStartOrEndSequentialRole();

	@Test
	public void shouldShowInvalidStartsWithInvalidSequence() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(9);
		game.setNumber05(11);
		game.setNumber06(22);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidEndsWithInvalidSequence() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(8);
		game.setNumber04(58);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidGroupSequence() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(10);
		game.setNumber03(17);
		game.setNumber04(32);
		game.setNumber05(41);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void shouldShowValidSequenceInTheMiddle1() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(10);
		game.setNumber03(11);
		game.setNumber04(12);
		game.setNumber05(19);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}

	@Test
	public void shouldShowValidSequenceInTheMiddle2() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(10);
		game.setNumber03(17);
		game.setNumber04(18);
		game.setNumber05(19);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void shouldShowValidSequenceJunsTwoNumberInSequenceAtStart() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(6);
		game.setNumber03(15);
		game.setNumber04(32);
		game.setNumber05(36);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void shouldShowValidSequenceJunsTwoNumberInSequenceAtEnd() {
		Game game = new Game();
		game.setNumber01(5);
		game.setNumber02(10);
		game.setNumber03(15);
		game.setNumber04(32);
		game.setNumber05(33);
		game.setNumber06(60);
		boolean isValid = role.validate(game);
		Assert.assertTrue(isValid);
	}
	
}
