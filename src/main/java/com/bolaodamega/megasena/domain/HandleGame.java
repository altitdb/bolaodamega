package com.bolaodamega.megasena.domain;

import javax.persistence.Convert;
import javax.persistence.Entity;

import com.bolaodamega.megasena.roles.Role;

@Entity(name = "HANDLE_GAME")
public class HandleGame extends Game {

	@Convert(converter = RoleConverter.class)
	private Role role;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
