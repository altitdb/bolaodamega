package com.bolaodamega.megasena.domain;

import javax.persistence.Convert;
import javax.persistence.Entity;

import com.bolaodamega.megasena.roles.Role;

@Entity(name = "excluded_game")
public class ExcludedGame extends Game {

    @Convert(converter = RoleConverter.class)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
