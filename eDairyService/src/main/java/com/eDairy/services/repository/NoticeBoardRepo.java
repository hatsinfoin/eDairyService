package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.NoticeBoardDetails;


public interface NoticeBoardRepo extends MongoRepository<NoticeBoardDetails,String>
{


}



