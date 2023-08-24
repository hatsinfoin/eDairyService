package com.eDairy.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.EDairy;
import com.eDairy.services.services.EDairyServices;

@RestController
@RequestMapping("/v1/Dairy")
public class EDairyController {

	private final EDairyServices EDairyServices;

	public EDairyController(EDairyServices EDairyServices) {
		this.EDairyServices = EDairyServices;
	}

	@GetMapping("/getAllEDairy")
	public ResponseEntity<List<EDairy>> getAllNotices() {

		System.out.println(" in controler getAllNotices");

		return ResponseEntity.ok(EDairyServices.getAllEDairy());
	}

	@PostMapping("/saveEDairy")
	public ResponseEntity<EDairy> saveEDairy(@RequestBody EDairy EDairy) {
		return ResponseEntity.ok(EDairyServices.saveEDairy(EDairy));
	}

	@GetMapping("/searchEDairyStatusByAcadamicYear/{eDairyId}/{academicYear}/{standardId}/{branchId}/{subjectID}")
	public ResponseEntity<List<EDairy>> geteDairyStatusByStandardandByDate(@PathVariable String eDairyId, @PathVariable String academicYear,
			@PathVariable String standardId, @PathVariable String branchId, @PathVariable String subjectID) {
		return ResponseEntity.ok(EDairyServices.geteDairyStatusByStandardandByDate(eDairyId, academicYear, standardId,
				branchId, subjectID));

	}

}
