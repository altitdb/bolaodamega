package com.bolaodamega.megasena.roles;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers only can be in the same row at maximum thrice times.
 * 
 * Example 01 (Incorrect): 1, 2, 3, 4, 5, 6
 * Example 02 (Incorrect): 1, 2, 3, 4, 5, 10
 * Example 03 (Incorrect): 11, 12, 13, 16, 55, 56
 * Example 04 (Correct): 11, 12, 17, 41, 46, 60 
 * @author ALM
 *
 */
public class NumbersSameRowRoleTest {

    private Role role = new NumbersSameRowRole();
    
    @Test
    public void shouldShowInvalidSameFirstRow() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(2);
        game.setNumber03(3);
        game.setNumber04(4);
        game.setNumber05(5);
        game.setNumber06(6);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameSecondRow() {
        Game game = new Game();
        game.setNumber01(13);
        game.setNumber02(14);
        game.setNumber03(15);
        game.setNumber04(17);
        game.setNumber05(18);
        game.setNumber06(20);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameThirdRow() {
        Game game = new Game();
        game.setNumber01(23);
        game.setNumber02(25);
        game.setNumber03(27);
        game.setNumber04(28);
        game.setNumber05(29);
        game.setNumber06(30);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameFourthRow() {
        Game game = new Game();
        game.setNumber01(31);
        game.setNumber02(32);
        game.setNumber03(35);
        game.setNumber04(37);
        game.setNumber05(39);
        game.setNumber06(40);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameFifthRow() {
        Game game = new Game();
        game.setNumber01(41);
        game.setNumber02(42);
        game.setNumber03(45);
        game.setNumber04(47);
        game.setNumber05(49);
        game.setNumber06(50);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidSameSixthRow() {
        Game game = new Game();
        game.setNumber01(52);
        game.setNumber02(53);
        game.setNumber03(54);
        game.setNumber04(55);
        game.setNumber05(59);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFourNumberAtTheBegin() {
        Game game = new Game();
        game.setNumber01(41);
        game.setNumber02(42);
        game.setNumber03(45);
        game.setNumber04(47);
        game.setNumber05(53);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFourNumberAtTheMiddle() {
        Game game = new Game();
        game.setNumber01(31);
        game.setNumber02(42);
        game.setNumber03(45);
        game.setNumber04(47);
        game.setNumber05(48);
        game.setNumber06(60);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFourNumberAtTheEnd() {
        Game game = new Game();
        game.setNumber01(31);
        game.setNumber02(32);
        game.setNumber03(45);
        game.setNumber04(47);
        game.setNumber05(48);
        game.setNumber06(50);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFiveNumberAtTheBegin() {
        Game game = new Game();
        game.setNumber01(41);
        game.setNumber02(42);
        game.setNumber03(45);
        game.setNumber04(47);
        game.setNumber05(48);
        game.setNumber06(55);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidWithFiveNumberAtTheEnd() {
        Game game = new Game();
        game.setNumber01(31);
        game.setNumber02(42);
        game.setNumber03(45);
        game.setNumber04(47);
        game.setNumber05(48);
        game.setNumber06(50);
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
