package com.eDairy.services.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eDairy.services.model.HolidayLists;
import com.eDairy.services.repository.HolidayListsRepository;

@Service
public class HolidayListsServices {
	
	@Autowired
	HolidayListsRepository holidayListsRepository;

	public List<HolidayLists> getAllHolidays() {
		return holidayListsRepository.findAll();
	}

	public HolidayLists SaveHolidaysLists(HolidayLists holidayLists) {
		return holidayListsRepository.save(holidayLists);
	}
	
	public List<HolidayLists> SaveHolidaysLists(List<HolidayLists> holidayLists) {
		return holidayListsRepository.saveAll(holidayLists);
	}
	
	
	

}
