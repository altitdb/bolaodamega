package com.bolaodamega.megasena.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MINE_GAME")
public class MineGame extends Game {

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	@Column(name = "LAST_UPDATE")
	private LocalDateTime lastUpdate = LocalDateTime.now();

	public User getUser() {
		return user;
	}

}
