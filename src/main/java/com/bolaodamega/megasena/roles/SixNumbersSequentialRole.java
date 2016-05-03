package com.bolaodamega.megasena.roles;

import java.util.HashSet;
import java.util.Set;

import com.bolaodamega.megasena.domain.Game;

public class SixNumbersSequentialRole implements Role {

    public boolean validate(Game game) {
        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(game.getNumber01() + 5);
        numbers.add(game.getNumber02() + 4);
        numbers.add(game.getNumber03() + 3);
        numbers.add(game.getNumber04() + 2);
        numbers.add(game.getNumber05() + 1);
        numbers.add(game.getNumber06());
        if (numbers.size() == 1) {
            return true;
        }
        return false;
    }

}
