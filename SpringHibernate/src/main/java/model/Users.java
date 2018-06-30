package model;

import java.time.LocalDate;

public class Users {

	private int Id;
	private String username;
	private LocalDate creationDate;
	
	public Users(int Id, String username, LocalDate creationDate) {
		this.Id = Id;
		this.username = username;
		this.creationDate = creationDate;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
}
