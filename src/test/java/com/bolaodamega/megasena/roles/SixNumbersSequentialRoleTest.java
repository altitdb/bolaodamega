package com.bolaodamega.megasena.roles;

import org.junit.Assert;
import org.junit.Test;

import com.bolaodamega.megasena.domain.Game;

public class SixNumbersSequentialRoleTest {

    private Role role = new SixNumbersSequentialRole();
    
    @Test
    public void shouldShowInvalid() {
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
    public void shouldShowValidNumber() {
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
    
    @Test
    public void shouldShowValid() {
        Game game = new Game();
        game.setNumber01(1);
        game.setNumber02(2);
        game.setNumber03(3);
        game.setNumber04(4);
        game.setNumber05(5);
        game.setNumber06(7);
        boolean isInvalid = role.validate(game);
        Assert.assertFalse(isInvalid);
    }
}
