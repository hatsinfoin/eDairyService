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

import com.eDairy.services.model.BranchDetails;
import com.eDairy.services.model.BranchDetailsStudentList;
import com.eDairy.services.model.Student;
import com.eDairy.services.services.BranchDetailsServices;

@RestController
@RequestMapping("/v1/branchDetails")
public class BranchDetailsController {

    private final BranchDetailsServices branchDetailsServices;

    public BranchDetailsController(BranchDetailsServices branchDetailsServices) {
        this.branchDetailsServices = branchDetailsServices;
    }

    @GetMapping("/getAllNotices")
    public ResponseEntity<List<BranchDetails>> getAllNotices(){
    		return ResponseEntity.ok(branchDetailsServices.getAllBranchDetails());
    }
    
    @PostMapping("/saveBranchDetails")
    public ResponseEntity<BranchDetails> saveNoticeBoard(@RequestBody  BranchDetails branchDetails ){
    System.out.println("in controler saveBranchDetails "+branchDetails);
    		return ResponseEntity.ok(branchDetailsServices.saveBranchDetails(branchDetails));
    }
    
    @GetMapping("/searchByStudentRoleNo/{text}")
	@ResponseBody
	public List<BranchDetails> search(@PathVariable String text) {
		System.out.println("findByRollNo text = "+text);
		return branchDetailsServices.findByBranchId(text);
	}
    
    @GetMapping("/findAllBStudentsByBranchId/{branchId}")
	@ResponseBody
	public List<BranchDetailsStudentList> findAllBStudentsByBranchId(@PathVariable String branchId) {
		System.out.println("findByRollNo branchId = "+branchId);
		return branchDetailsServices.findAllBStudentsByBranchId(branchId);
	}
    
}
