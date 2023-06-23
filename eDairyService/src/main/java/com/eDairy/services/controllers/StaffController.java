package com.eDairy.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.Staff;
import com.eDairy.services.services.StaffServices;
import com.eDairy.services.services.StaffServices;

@RestController
@RequestMapping("/v1/Staff")
public class StaffController {

	private final StaffServices staffServices;

	public StaffController(StaffServices staffServices) {
		this.staffServices = staffServices;
	}

	@GetMapping("/getAllStaffs")
	public ResponseEntity<List<Staff>> getAllNotices() {
		return ResponseEntity.ok(staffServices.getAllStaffs());
	}

	@PostMapping("/saveStaff")
	public ResponseEntity<Staff> saveNoticeBoard(@RequestBody Staff staff) {
		System.out.println("in controler saveOfficeStaffDetails " + staff);
		return ResponseEntity.ok(staffServices.saveOfficeStaff(staff));
	}

	@GetMapping("/findByStaffId/{staffId}")
	@ResponseBody
	public List<Staff> search(@PathVariable String staffId) {
		System.out.println("findByRollNo text = " + staffId);
		return staffServices.findByStaffId(staffId);
	}

}
