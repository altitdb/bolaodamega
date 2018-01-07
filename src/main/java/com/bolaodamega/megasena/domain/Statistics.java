package com.bolaodamega.megasena.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Statistics implements Serializable {

	private static final long serialVersionUID = 23L;
	@Id
	@Column
	private Integer id;
	@Column
	private String description;
	@Column
	private Long value;
	@Column(name = "LAST_UPDATE")
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
