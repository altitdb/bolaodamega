package com.bolaodamega.megasena.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Statistics")
@TypeAlias("Statistics")
public class Statistics implements Serializable {

	private static final long serialVersionUID = 23L;
	@Id
	private Integer id;
	private String description;
	private Long value;
	private LocalDateTime lastUpdate = LocalDateTime.now();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

}
