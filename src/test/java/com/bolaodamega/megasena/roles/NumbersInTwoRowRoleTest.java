package com.bolaodamega.megasena.roles;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

/**
 * The numbers can't be only two rows.
 * 
 * @author ALM
 *
 */
public class NumbersInTwoRowRoleTest {

    private Role role = new NumbersInTwoRowRole();
    
    @Test
    public void shouldShowInvalidInFirstTwoRows() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(4);
        game.setNumber03(6);
        game.setNumber04(11);
        game.setNumber05(15);
        game.setNumber06(18);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidInMiddleTwoRows() {
        Game game = new Game();
        game.setNumber01(21);
        game.setNumber02(24);
        game.setNumber03(25);
        game.setNumber04(31);
        game.setNumber05(35);
        game.setNumber06(38);
        boolean result = role.validate(game);
        assertTrue(result);
    }
    
    @Test
    public void shouldShowInvalidInLastTwoRows() {
        Game game = new Game();
        game.setNumber01(41);
        game.setNumber02(44);
        game.setNumber03(46);
        game.setNumber04(51);
        game.setNumber05(55);
        game.setNumber06(58);
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
