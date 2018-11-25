package com.bolaodamega.megasena.domain;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bolaodamega.megasena.roles.Role;

@Document(collection = "ExcludedGame")
@TypeAlias("ExcludedGame")
public class ExcludedGame extends Game {

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
