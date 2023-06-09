package com.eDairy.services.model;

public class User {

	 
	private String login;
	private String password;
	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + "]";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	  

	
}
