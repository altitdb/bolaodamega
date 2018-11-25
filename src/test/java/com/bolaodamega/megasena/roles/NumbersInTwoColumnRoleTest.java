package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can't be only two columns.
 * 
 * @author ALM
 *
 */
public class NumbersInTwoColumnRoleTest {

    private Role role = new NumbersInTwoColumnRole();
    
    @Test
    public void shouldShowInvalidInFirstTwoColumns() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(11);
        game.setNumber03(12);
        game.setNumber04(31);
        game.setNumber05(42);
        game.setNumber06(52);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidInMiddleTwoColumns() {
        Game game = new Game();
        game.setNumber01(5);
        game.setNumber02(6);
        game.setNumber03(35);
        game.setNumber04(46);
        game.setNumber05(55);
        game.setNumber06(56);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidInLastTwoColumns() {
        Game game = new Game();
        game.setNumber01(9);
        game.setNumber02(20);
        game.setNumber03(29);
        game.setNumber04(30);
        game.setNumber05(50);
        game.setNumber06(59);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowValid() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(24);
        game.setNumber03(26);
        game.setNumber04(31);
        game.setNumber05(45);
        game.setNumber06(58);
        boolean result = role.validate(game);
        assertFalse(result);
    }
}
