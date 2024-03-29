package com.eDairy.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.HolidayLists;
import com.eDairy.services.services.HolidayListsServices;

@RestController
@RequestMapping("/v1/holidayLists")
public class HolidayListsController {

	private final HolidayListsServices holidayListsServices;

	public HolidayListsController(HolidayListsServices holidayListsServices) {
		this.holidayListsServices = holidayListsServices;
	}

	@GetMapping("/getAllHollidays")
	public ResponseEntity<List<HolidayLists>> getAllNotices() {
		return ResponseEntity.ok(holidayListsServices.getAllHolidays());
	}
	
	@GetMapping("/getAllHolidaysByBranchId/{branchId}")
	public ResponseEntity<List<HolidayLists>> getAllHolidaysByBranchId(@PathVariable String branchId) {
		return ResponseEntity.ok(holidayListsServices.getAllHolidaysByBranchId(branchId));
	}
	

	@PostMapping("/saveHolidaysList")
	public ResponseEntity<HolidayLists> saveNoticeBoard(@RequestBody HolidayLists holidayLists) {
		System.out.println("HolidayLists  - "+holidayLists);
		return ResponseEntity.ok(holidayListsServices.SaveHolidaysLists(holidayLists));
	}
	
	@GetMapping("/getholidayByDate/{holidayDate}")
	public ResponseEntity<List<HolidayLists>> getholidayByDate(@PathVariable String holidayDate) {
		return ResponseEntity.ok(holidayListsServices.getholidayByDate(holidayDate));
	}

	@PostMapping("/deleteHoliday")
	public ResponseEntity<String> deleteHoliday(@RequestBody HolidayLists holidayLists) {
		System.out.println("HolidayLists  - "+holidayLists);
		holidayListsServices.deleteHoliday(holidayLists);
		return ResponseEntity.ok("OK");
	}
	
}
