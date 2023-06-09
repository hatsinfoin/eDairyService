package com.eDairy.services.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.config.UserAuthenticationProvider;
import com.eDairy.services.dto.SignUpDto;
import com.eDairy.services.dto.UserDto;
import com.eDairy.services.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {

	private final UserService userService;
	private final UserAuthenticationProvider userAuthenticationProvider;

	public AuthenticationController(UserService userService, UserAuthenticationProvider userAuthenticationProvider) {
		this.userService = userService;
		this.userAuthenticationProvider = userAuthenticationProvider;
	}

	@PostMapping("/signIn")
	public ResponseEntity<UserDto> signIn(@AuthenticationPrincipal UserDto user) {
		System.out.println( "/ signing "+user);
		user.setToken(userAuthenticationProvider.createToken(user.getLogin()));
		return ResponseEntity.ok(user);
	}

	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@RequestBody @Valid SignUpDto user) {
		System.out.println(" user getLogin "+user.getLogin());
		if(userService.searchUser(user.getLogin()) == null) {
			SignUpDto createdUser = userService.signUp(user);
			return ResponseEntity.ok(createdUser.toString());
		}
		
		return ResponseEntity.ok("User Already Exist");

		// return ResponseEntity.created(URI.create("/users/" + createdUser.getLogin() +
		// "/profile")).body(createdUser);
	}

	@PostMapping("/signOut")
	public ResponseEntity<Void> signOut(@AuthenticationPrincipal UserDto user) {
		SecurityContextHolder.clearContext();
		return ResponseEntity.noContent().build();
	}
}
