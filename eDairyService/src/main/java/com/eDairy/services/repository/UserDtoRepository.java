package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.dto.SignUpDto;


public interface UserDtoRepository extends MongoRepository<SignUpDto,String>
{

//	List<User> findByName(String name);
//
//	@Query("{'Address.city':?0}")
//	List<User> findByCity(String city);
	
	SignUpDto  findByLogin(String name);
}



