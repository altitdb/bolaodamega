package com.bolaodamega.megasena.roles;

import com.bolaodamega.megasena.domain.Game;

public interface Role {

    boolean validate(Game game);
    
    int value();
    
}
