package com.eDairy.services.dto;


import jakarta.validation.constraints.NotEmpty;

public class SignUpDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    public SignUpDto() {
        super();
    }

    public SignUpDto(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String login, @NotEmpty String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
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

	@Override
	public String toString() {
		return "SignUpDto [firstName=" + firstName + ", lastName=" + lastName + ", login=" + login + ", password="
				+ password + "]";
	}
    
    
}
