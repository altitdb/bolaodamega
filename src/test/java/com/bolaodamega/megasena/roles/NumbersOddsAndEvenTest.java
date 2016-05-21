package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers only can to have four numbers odds in maximum Example 01
 * (Incorrect): 2, 4, 6, 8, 10, 12 Example 02 (Incorrect): 2, 4, 6, 8, 10, 35
 * Example 03 (Correct): 2, 5, 6, 7, 10, 20 Example 04 (Correct): 2, 4, 6, 29,
 * 41, 55 Example 05 (Correct): 2, 5, 6, 9, 10, 55
 * 
 * The numbers only can to have four numbers even in maximum Example 01
 * (Incorrect): 3, 5, 7, 9, 11, 13 Example 02 (Incorrect): 3, 5, 7, 10, 11, 13
 * Example 03 (Correct): 3, 6, 7, 10, 11, 13 Example 04 (Correct): 2, 4, 6, 29,
 * 41, 55 Example 05 (Correct): 2, 5, 6, 9, 10, 55
 * 
 * @author ALM
 *
 */
public class NumbersOddsAndEvenTest {

	private Role role = new NumbersOddsAndEvenRole();

	@Test
	public void shoudShowInvalidForSixNumberOdds() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(5);
		game.setNumber04(7);
		game.setNumber05(9);
		game.setNumber06(11);
		boolean result = role.validate(game);
		assertTrue(result);
	}

	@Test
	public void shoudShowInvalidForFiveNumberOddsInTheBegin() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(5);
		game.setNumber04(7);
		game.setNumber05(13);
		game.setNumber06(50);
		boolean result = role.validate(game);
		assertTrue(result);
	}

	@Test
	public void shoudShowInvalidForFiveNumberOddsInTheEnd() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(3);
		game.setNumber03(5);
		game.setNumber04(7);
		game.setNumber05(9);
		game.setNumber06(11);
		boolean result = role.validate(game);
		assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidForFiveNumbersOddsRandomized() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(3);
		game.setNumber04(7);
		game.setNumber05(9);
		game.setNumber06(11);
		boolean result = role.validate(game);
		assertTrue(result);
		
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(2);
		game.setNumber04(7);
		game.setNumber05(9);
		game.setNumber06(11);
		result = role.validate(game);
		assertTrue(result);
		
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(5);
		game.setNumber04(2);
		game.setNumber05(9);
		game.setNumber06(11);
		result = role.validate(game);
		assertTrue(result);
		
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(5);
		game.setNumber04(7);
		game.setNumber05(2);
		game.setNumber06(11);
		result = role.validate(game);
		assertTrue(result);
	}
	
	

	@Test
	public void shoudShowInvalidForSixNumberEven() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(6);
		game.setNumber04(8);
		game.setNumber05(10);
		game.setNumber06(12);
		boolean result = role.validate(game);
		assertTrue(result);
	}

	@Test
	public void shoudShowInvalidForFiveNumberEvenInTheBegin() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(3);
		game.setNumber03(5);
		game.setNumber04(7);
		game.setNumber05(9);
		game.setNumber06(11);
		
		boolean result = role.validate(game);
		assertTrue(result);
	}

	@Test
	public void shoudShowInvalidForFiveNumberEvenInTheEnd() {
		Game game = new Game();
		game.setNumber01(3);
		game.setNumber02(5);
		game.setNumber03(7);
		game.setNumber04(9);
		game.setNumber05(11);
		game.setNumber06(50);
		boolean result = role.validate(game);
		assertTrue(result);
	}
	
	@Test
	public void shoudShowInvalidForFiveNumbersEvenRandomized() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(33);
		game.setNumber03(6);
		game.setNumber04(8);
		game.setNumber05(10);
		game.setNumber06(12);
		boolean result = role.validate(game);
		assertTrue(result);
		
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(33);
		game.setNumber04(8);
		game.setNumber05(10);
		game.setNumber06(12);
		result = role.validate(game);
		assertTrue(result);
		
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(6);
		game.setNumber04(33);
		game.setNumber05(10);
		game.setNumber06(12);
		result = role.validate(game);
		assertTrue(result);
		
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(6);
		game.setNumber04(8);
		game.setNumber05(33);
		game.setNumber06(12);
		result = role.validate(game);
		assertTrue(result);
	}

	@Test
	public void shoudShowValidInSequenceFourOddsInTheBegin() {
		Game game = new Game();
		game.setNumber01(3);
		game.setNumber02(5);
		game.setNumber03(7);
		game.setNumber04(9);
		game.setNumber05(14);
		game.setNumber06(18);
		boolean result = role.validate(game);
		assertFalse(result);
	}
	
	@Test
	public void shoudShowValidInSequenceFourOddsInTheEnd() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(7);
		game.setNumber04(9);
		game.setNumber05(11);
		game.setNumber06(13);
		boolean result = role.validate(game);
		assertFalse(result);
	}

	@Test
	public void shoudShowValidFourOddsRandomized() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(3);
		game.setNumber03(7);
		game.setNumber04(9);
		game.setNumber05(11);
		game.setNumber06(40);
		boolean result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(2);
		game.setNumber02(3);
		game.setNumber03(7);
		game.setNumber04(9);
		game.setNumber05(40);
		game.setNumber06(13);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(2);
		game.setNumber02(3);
		game.setNumber03(7);
		game.setNumber04(40);
		game.setNumber05(11);
		game.setNumber06(13);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(2);
		game.setNumber02(3);
		game.setNumber03(40);
		game.setNumber04(9);
		game.setNumber05(11);
		game.setNumber06(13);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(2);
		game.setNumber02(40);
		game.setNumber03(7);
		game.setNumber04(9);
		game.setNumber05(11);
		game.setNumber06(13);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(7);
		game.setNumber04(9);
		game.setNumber05(40);
		game.setNumber06(13);
		result = role.validate(game);
		assertFalse(result);
	}
	
	@Test
	public void shoudShowValidInSequenceFourEvenInTheBegin() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(6);
		game.setNumber04(8);
		game.setNumber05(13);
		game.setNumber06(19);
		boolean result = role.validate(game);
		assertFalse(result);
	}
	
	@Test
	public void shoudShowValidInSequenceFourEvenInTheEnd() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(6);
		game.setNumber04(8);
		game.setNumber05(10);
		game.setNumber06(12);
		boolean result = role.validate(game);
		assertFalse(result);
	}
	
	@Test
	public void shoudShowValidFourEvenRandomized() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(4);
		game.setNumber04(6);
		game.setNumber05(8);
		game.setNumber06(33);
		boolean result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(4);
		game.setNumber04(6);
		game.setNumber05(33);
		game.setNumber06(10);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(4);
		game.setNumber04(33);
		game.setNumber05(8);
		game.setNumber06(10);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(1);
		game.setNumber02(2);
		game.setNumber03(33);
		game.setNumber04(6);
		game.setNumber05(8);
		game.setNumber06(10);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(1);
		game.setNumber02(33);
		game.setNumber03(4);
		game.setNumber04(6);
		game.setNumber05(8);
		game.setNumber06(10);
		result = role.validate(game);
		assertFalse(result);
		
		game.setNumber01(2);
		game.setNumber02(23);
		game.setNumber03(4);
		game.setNumber04(6);
		game.setNumber05(33);
		game.setNumber06(10);
		result = role.validate(game);
		assertFalse(result);
	}
	
	@Test
	public void shoudShowValidInSequenceThreeEvenInTheBegin() {
		Game game = new Game();
		game.setNumber01(2);
		game.setNumber02(4);
		game.setNumber03(6);
		game.setNumber04(11);
		game.setNumber05(21);
		game.setNumber06(35);
		boolean result = role.validate(game);
		assertFalse(result);
	}
	
	@Test
	public void shoudShowValidInSequenceThreeEvenInTheEnd() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(3);
		game.setNumber03(5);
		game.setNumber04(8);
		game.setNumber05(10);
		game.setNumber06(12);
		boolean result = role.validate(game);
		assertFalse(result);
	}
	
	@Test
	public void shoudShowValidThreeOutOfSequence() {
		Game game = new Game();
		game.setNumber01(1);
		game.setNumber02(10);
		game.setNumber03(21);
		game.setNumber04(24);
		game.setNumber05(33);
		game.setNumber06(40);
		boolean result = role.validate(game);
		assertFalse(result);
	}
}
