package com.bolaodamega.megasena.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@TypeAlias("User")
public class User {

	@Id
	private Long id;
	private String email;
	private String name;
	private String taxIdentifier;
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
