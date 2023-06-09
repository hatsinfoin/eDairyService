package com.eDairy.services.services;

import java.nio.CharBuffer;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eDairy.services.dto.CredentialsDto;
import com.eDairy.services.dto.SignUpDto;
import com.eDairy.services.dto.UserDto;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public AuthenticationService(UserService userService ,PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userService= userService;
    }

    public UserDto authenticate(CredentialsDto credentialsDto) {
    	System.out.println("In authenticate");
    	System.out.println(credentialsDto.getLogin());
       // String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap("the-password"));
        
	SignUpDto createdUser = userService.searchUser(credentialsDto.getLogin());
    	
	System.out.println(" createdUser "+createdUser);
	System.out.println(" createdUser getLogin "+createdUser.getLogin());
	System.out.println("credentialsDto - "+credentialsDto.getPassword());
	System.out.println(" createdUser getPassword "+createdUser.getPassword());
	System.out.println(" if  "+createdUser.getPassword().equals(credentialsDto.getPassword()));

	if(createdUser != null) {
    		System.out.println(createdUser);
    		if(createdUser.getPassword().equals(credentialsDto.getPassword())) {
    			System.out.println(" Password matches returnig createdUser="+createdUser);
    			return new UserDto(1L, createdUser.getFirstName(),createdUser.getLastName(), createdUser.getLogin(), "token");
    			//return createdUser;
     		}
    	}
    	
        
         
        throw new RuntimeException("Invalid password");
    }

    public UserDto findByLogin(String login) {
    	System.out.println("login "+login );
    	SignUpDto createdUser = userService.searchUser(login);

    	if(createdUser != null) {
    		System.out.println(createdUser);
    		if(createdUser.getLogin().equals(login)) {
    			System.out.println(" Password matches returnig createdUser="+createdUser);
    			return new UserDto(1L, createdUser.getFirstName(),createdUser.getLastName(), createdUser.getLogin(), "token");
    			//return createdUser;
     		}
    	}
    	
       
        throw new RuntimeException("Invalid login");
    }
}
