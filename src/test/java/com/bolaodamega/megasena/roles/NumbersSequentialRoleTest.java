package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;
import com.bolaodamega.megasena.domain.Game;

public class NumbersSequentialRoleTest {

	private Role role = new NumbersSequentialRole();

	@Test
	public void shouldShowInvalidSixSequence() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(4);
		game.setNumber05(5);
		game.setNumber06(6);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowInvalidFiveSequenceAtBegin() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(4);
		game.setNumber05(5);
		game.setNumber06(35);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowInvalidFiveSequenceAtEnd() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(6);
		game.setNumber03(7);
		game.setNumber04(8);
		game.setNumber05(9);
		game.setNumber06(10);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowInvalidFourSequenceAtBegin() {
		Game game = new Game();
		game.setNumber01(21);
		game.setNumber02(22);
		game.setNumber03(23);
		game.setNumber04(24);
		game.setNumber05(30);
		game.setNumber06(40);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowInvalidFourSequenceAtMiddle() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(22);
		game.setNumber03(23);
		game.setNumber04(24);
		game.setNumber05(25);
		game.setNumber06(44);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowInvalidFourSequenceAtEnd() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(7);
		game.setNumber03(31);
		game.setNumber04(32);
		game.setNumber05(33);
		game.setNumber06(34);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowInvalidThreeSequenceAtBegin() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(22);
		game.setNumber05(33);
		game.setNumber06(44);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidThreeSequenceAtMiddle() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(10);
		game.setNumber03(11);
		game.setNumber04(12);
		game.setNumber05(33);
		game.setNumber06(44);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
		
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(11);
		game.setNumber04(12);
		game.setNumber05(13);
		game.setNumber06(44);
		isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidThreeSequenceAtEnd() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(7);
		game.setNumber03(12);
		game.setNumber04(32);
		game.setNumber05(33);
		game.setNumber06(34);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}

	@Test
	public void shouldShowValidAllDifferentNumbers() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(21);
		game.setNumber03(30);
		game.setNumber04(49);
		game.setNumber05(57);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}

	@Test
	public void shouldShowValidTwoSequenceAtBegin() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(30);
		game.setNumber04(49);
		game.setNumber05(57);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidTwoSequenceAtMiddle() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(11);
		game.setNumber03(12);
		game.setNumber04(49);
		game.setNumber05(57);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
		
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(12);
		game.setNumber04(13);
		game.setNumber05(57);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
		
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(6);
		game.setNumber04(13);
		game.setNumber05(14);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidTwoSequenceAtEnd() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(15);
		game.setNumber03(30);
		game.setNumber04(42);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}

	@Test
	public void shouldShowValidWithTwoGroupOfTwoAtBegin() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(25);
		game.setNumber04(34);
		game.setNumber05(49);
		game.setNumber06(50);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);

		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(20);
		game.setNumber04(49);
		game.setNumber05(50);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);

		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(49);
		game.setNumber04(50);
		game.setNumber05(55);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidWithTwoGroupOfTwoAtMiddle() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(11);
		game.setNumber03(12);
		game.setNumber04(23);
		game.setNumber05(24);
		game.setNumber06(55);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidWithTwoGroupOfTwoAtEnd() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(25);
		game.setNumber04(34);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);

		game.setNumber01(2);
		game.setNumber02(10);
		game.setNumber03(11);
		game.setNumber04(49);
		game.setNumber05(59);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);

		game.setNumber01(2);
		game.setNumber02(5);
		game.setNumber03(10);
		game.setNumber04(11);
		game.setNumber05(59);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}

	@Test
	public void shouldShowValidWithThreeGroupOfTwo() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(30);
		game.setNumber04(31);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}

}
