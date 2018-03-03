package com.bolaodamega.megasena.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PlayedGame")
@TypeAlias("PlayedGame")
public class PlayedGame extends Game {

	private User user;
	private LocalDateTime played = LocalDateTime.now();

	public User getUser() {
		return user;
	}

	public LocalDateTime getPlayed() {
		return played;
	}

}
