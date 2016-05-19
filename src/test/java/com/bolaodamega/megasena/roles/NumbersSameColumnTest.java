package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers only can be in the same column at maximum thrice times.
 * 
 * Example 01 (Incorrect): 1, 11, 21, 31, 41, 51
 * Example 02 (Incorrect): 1, 11, 21, 25, 41, 51
 * Example 03 (Incorrect): 1, 10, 26, 31, 41, 51
 * Example 04 (Correct): 11, 21, 35, 40, 41, 60 
 * @author ALM
 *
 */
public class NumbersSameColumnTest {

    private Role role = new NumbersSameColumn();
    
    @Test
    public void shouldShowInvalidSameFirstColumn() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(11);
        game.setNumber03(21);
        game.setNumber04(31);
        game.setNumber05(41);
        game.setNumber06(51);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameSecondColumn() {
        Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(12);
        game.setNumber03(22);
        game.setNumber04(32);
        game.setNumber05(42);
        game.setNumber06(52);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameFourthColumn() {
        Game game = new Game();
        game.setNumber01(4);
        game.setNumber02(14);
        game.setNumber03(24);
        game.setNumber04(34);
        game.setNumber05(44);
        game.setNumber06(54);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameSixthColumn() {
        Game game = new Game();
        game.setNumber01(6);
        game.setNumber02(16);
        game.setNumber03(26);
        game.setNumber04(36);
        game.setNumber05(46);
        game.setNumber06(56);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFourNumberAtTheBegin() {
        Game game = new Game();
        game.setNumber01(2);
        game.setNumber02(12);
        game.setNumber03(22);
        game.setNumber04(32);
        game.setNumber05(53);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFourNumberAtTheMiddle() {
        Game game = new Game();
        game.setNumber01(4);
        game.setNumber02(16);
        game.setNumber03(26);
        game.setNumber04(36);
        game.setNumber05(46);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFourNumberAtTheEnd() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(5);
        game.setNumber03(14);
        game.setNumber04(24);
        game.setNumber05(34);
        game.setNumber06(44);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFiveNumberAtTheBegin() {
        Game game = new Game();
        game.setNumber01(3);
        game.setNumber02(13);
        game.setNumber03(23);
        game.setNumber04(33);
        game.setNumber05(43);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFiveNumberAtTheEnd() {
        Game game = new Game();
        game.setNumber01(3);
        game.setNumber02(16);
        game.setNumber03(26);
        game.setNumber04(36);
        game.setNumber05(46);
        game.setNumber06(56);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowValid() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(12);
        game.setNumber03(25);
        game.setNumber04(37);
        game.setNumber05(48);
        game.setNumber06(52);
        boolean result = role.validate(game);
        assertFalse(result);
    }
}
