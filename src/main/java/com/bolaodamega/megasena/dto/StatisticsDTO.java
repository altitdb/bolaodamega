package com.bolaodamega.megasena.dto;

import java.time.LocalDateTime;

public class StatisticsDTO {

	private String description;
	private Long value;
	private LocalDateTime lastUpdate;
	
	public StatisticsDTO(String description, Long value, LocalDateTime lastUpdate) {
		this.description = description;
		this.value = value;
		this.lastUpdate = lastUpdate;
	}

	public String getDescription() {
		return description;
	}

	public Long getValue() {
		return value;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

}
