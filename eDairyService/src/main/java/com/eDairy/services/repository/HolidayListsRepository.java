package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.HolidayLists;

public interface HolidayListsRepository extends MongoRepository<HolidayLists, String> {

}
