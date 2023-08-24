package com.eDairy.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.Leave;
import com.eDairy.services.services.LeaveService;

@RestController
@RequestMapping("/v1/Dairy")
public class LeaveController {

	private final LeaveService leaveService;

	public LeaveController(LeaveService LeaveService) {
		this.leaveService = LeaveService;
	}

//	@GetMapping("/getAllEDairy")
//	public ResponseEntity<List<Leave>> getAllNotices() {
//
//		System.out.println(" in controler getAllNotices");
//
//		return ResponseEntity.ok(leaveService.getAllEDairy());
//	}

	@PostMapping("/saveLeaveBy")
	public ResponseEntity<Leave> saveEDairy(@RequestBody Leave leave) {
		return ResponseEntity.ok(leaveService.saveLeave(leave));
	}

	@GetMapping("/getLeaveByDate/{leaveId}/{academicYear}/{standardId}/{branchId}/{leaveby}")
	public ResponseEntity<List<Leave>> getLeaveByDate(@PathVariable String leaveId, @PathVariable String academicYear,
			@PathVariable String standardId, @PathVariable String branchId, @PathVariable String leaveby) {
		return ResponseEntity.ok(leaveService.getLeaveByDate(leaveId, academicYear, standardId,
				branchId, leaveby));

	}

}
