package com.eDairy.services.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDairy.services.dto.*;
import com.eDairy.services.repository.UserDtoRepository;

@Service
public class UserService {

	@Autowired
	UserDtoRepository userDtoRepository;
	
    public ProfileDto getProfile(Long userId) {
        return new ProfileDto(new UserSummaryDto(1L, "Sergio", "Lema"),
                Arrays.asList(new UserSummaryDto(2L, "John", "Doe")),
                Arrays.asList(new MessageDto(1L, "My message")),
                Arrays.asList(new ImageDto(1L, "Title", null)));
    }

    public void addFriend(Long friendId) {
        return;
    }

    public List<UserSummaryDto> searchUsers(String term) {
        return Arrays.asList(new UserSummaryDto(1L, "Sergio", "Lema"),
                new UserSummaryDto(2L, "John", "Doe"));
    }
    
    public SignUpDto searchUser(String loginId) {
    	System.out.println("in searchUser loginId "+loginId);
    	return userDtoRepository.findByLogin(loginId);
    }

    public SignUpDto signUp(SignUpDto user) {
    	return userDtoRepository.save(user);
        //return new UserDto(1L, "Sergio", "Lema", "login", "token");
    }

    public void signOut(UserDto user) {
        // nothing to do at the moment
    }
    
    
}
