package com.eDairy.services.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eDairy.services.model.HolidayLists;
import com.eDairy.services.model.StudentAttendance;

public interface StudentAttendanceRepo extends MongoRepository<StudentAttendance, String> {

}
