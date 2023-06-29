package com.eDairy.services.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.Standard;
import com.eDairy.services.model.StandardSubjects;
import com.eDairy.services.services.StandardService;

@RestController
@RequestMapping("/v1/standard")
public class StandardController {

	private final StandardService standardService;

	public StandardController(StandardService standardService) {
	        this.standardService = standardService;
	       
	    }

	@GetMapping("/standard/{standardId}")
	public List<StandardSubjects> getAllNotices(@PathVariable String standardId) {
		return standardService.getStandardById(standardId);
	}
	
	@GetMapping("/findAllStandards")
	public List<Standard> getAllStandards() {
		return standardService.getAllStandards();
	}
	
	@GetMapping("/getSubjectsByStandardId/{standardId}")
	public List<StandardSubjects> getSubjectsByStandardId(@PathVariable String standardId) {
		return standardService.findAllSubjectsByStandardId(standardId);
	}
	
	@GetMapping("/findByStandardID/{standardId}")
	public List<StandardSubjects> findByStandardID(@PathVariable String standardId) {
		return standardService.findByStandardID(standardId);
	}
	
	@GetMapping("/findByUniqueStandardIDByBranch/{branchId}")
	public Set<String> findByUniqueStandardIDByBranch(@PathVariable String branchId) {
		System.out.println("findByUniqueStandardIDByBranch"+branchId);
		return standardService.getAllUniqueStandardsBrBrnch(branchId);
	}
	
	@PostMapping("/saveStandard")
	  public Standard saveStandard(@RequestBody Standard Standard) {
	  
	 return standardService.saveStandard(Standard);
	  
	  }
	 
	@PostMapping("/deleteStandard")
	  public boolean deleteStandard(@RequestBody Standard Standard) {
	  
	  standardService.deleteStandard(Standard);
	  
	  return true;
	  
	  }
	
}
