package com.bookworld.domain;

public class Author {

	private Integer authorId;
	private String firstName;
	private String lastName;

	public Author(Integer authorId, String firstName, String lastName) {
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
