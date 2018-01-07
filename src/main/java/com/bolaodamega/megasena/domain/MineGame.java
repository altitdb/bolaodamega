package com.bolaodamega.megasena.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MINE_GAME")
public class MineGame extends Game {

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public User getUser() {
		return user;
	}

}
