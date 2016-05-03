package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;
import com.bolaodamega.megasena.domain.Game;

public class NumbersSequentialRoleTest {

	private Role role = new NumbersSequentialRole();

	// INVALID!
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
	public void shouldShowInvalidFiveSequence() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(6);
		game.setNumber03(7);
		game.setNumber04(8);
		game.setNumber05(9);
		game.setNumber06(10);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
		
		game.setNumber01(5);
		game.setNumber02(6);
		game.setNumber03(7);
		game.setNumber04(8);
		game.setNumber05(9);
		game.setNumber06(20);
		isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidFourSequence() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(23);
		game.setNumber04(24);
		game.setNumber05(25);
		game.setNumber06(26);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
		
		game.setNumber01(1);
		game.setNumber02(22);
		game.setNumber03(23);
		game.setNumber04(24);
		game.setNumber05(25);
		game.setNumber06(30);
		isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
		
		game.setNumber01(21);
		game.setNumber02(22);
		game.setNumber03(23);
		game.setNumber04(24);
		game.setNumber05(30);
		game.setNumber06(40);
		isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidThreeSequence() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(12);
		game.setNumber04(22);
		game.setNumber05(33);
		game.setNumber06(44);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
		
		game.setNumber01(2);
		game.setNumber02(10);
		game.setNumber03(11);
		game.setNumber04(12);
		game.setNumber05(33);
		game.setNumber06(44);
		isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
		
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(11);
		game.setNumber04(12);
		game.setNumber05(13);
		game.setNumber06(44);
		isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
		
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(6);
		game.setNumber04(12);
		game.setNumber05(13);
		game.setNumber06(14);
		isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	@Test
	public void shouldShowInvalidLastThreeOnSequence() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(5);
		game.setNumber03(9);
		game.setNumber04(21);
		game.setNumber05(22);
		game.setNumber06(23);
		boolean isInvalid = role.validate(game);
		Assert.assertTrue(isInvalid);
	}
	
	// VALID
	@Test
	public void shouldShowValidNumberAllDifferent() {
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
	public void shouldShowValidNumberOneGroupOfTwo() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(30);
		game.setNumber04(49);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
		
		game.setNumber01(2);
		game.setNumber02(11);
		game.setNumber03(12);
		game.setNumber04(49);
		game.setNumber05(59);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
		
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(12);
		game.setNumber04(13);
		game.setNumber05(59);
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
		
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(6);
		game.setNumber04(9);
		game.setNumber05(14);
		game.setNumber06(15);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidNumberTwoGroupOfTwo() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(11);
		game.setNumber03(33);
		game.setNumber04(35);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
		
		game.setNumber01(9);
		game.setNumber02(11);
		game.setNumber03(12);
		game.setNumber04(35);
		game.setNumber05(59);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
		
		game.setNumber01(3);
		game.setNumber02(9);
		game.setNumber03(12);
		game.setNumber04(13);
		game.setNumber05(59);
		game.setNumber06(60);
		isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}
	
	@Test
	public void shouldShowValidNumberThreeGroupOfTwo() {
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
	
	@Test
	public void shouldShowValidLastTwoOnSequence() {
		Game game = new Game();
		game.setNumber01(10);
		game.setNumber02(21);
		game.setNumber03(30);
		game.setNumber04(49);
		game.setNumber05(59);
		game.setNumber06(60);
		boolean isInvalid = role.validate(game);
		Assert.assertFalse(isInvalid);
	}

}
