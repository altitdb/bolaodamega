package com.bolaodamega.megasena.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@Column
	private Long id;
	@Column
	private String email;
	@Column
	private String name;
	@Column(name = "TAX_IDENTIFIER")
	private String taxIdentifier;
	@Column(name = "FACEBOOK_ID")
	private String facebookId;

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getTaxIdentifier() {
		return taxIdentifier;
	}

	public String getFacebookId() {
		return facebookId;
	}

}
