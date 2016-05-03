package com.bolaodamega.megasena.miner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.bolaodamega.megasena.domain.Game;
import com.bolaodamega.megasena.roles.Role;
import com.bolaodamega.megasena.roles.SixNumbersSequentialRole;

public class Miner {

    private Set<Role> roles = new HashSet<Role>();
    
    {
        roles.add(new SixNumbersSequentialRole());
    }
    
    public void start() {
        Set<Game> games = getGames();
        Iterator<Game> iterator = games.iterator();
        while(iterator.hasNext()) {
            Game game = iterator.next();
            for(Role role : roles) {
                boolean isValid = role.validate(game);
                if (isValid) {
                    removeGame(game);
                }
            }
        }
    }

    private void removeGame(Game game) {
        
    }

    private Set<Game> getGames() {
        return null;
    }
    
}
