package com.eDairy.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.ExamResults;
import com.eDairy.services.model.Exams;
import com.eDairy.services.model.ExamsModel;
import com.eDairy.services.services.ExamsServices;

@RestController
@RequestMapping("/v1/exams")
public class ExamsController {

    private final ExamsServices examsServices;

    public ExamsController(ExamsServices examsServices) {
        this.examsServices = examsServices;
    }

    @GetMapping("/getAllExams")
    public ResponseEntity<List<Exams>> getAllExams(){
    		return ResponseEntity.ok(examsServices.getAllExams());
    }
    
    @PostMapping("/saveExam")
    public ResponseEntity<Exams> saveExam(@RequestBody  Exams exams ){
    System.out.println("in controler exams "+exams);
    		return ResponseEntity.ok(examsServices.saveExams(exams));
    }
    
    @PostMapping("/createExamsForBranch/{branchId}")
    public ResponseEntity<List<Exams>> createExamsForBranch(@PathVariable  String branchId ){
    System.out.println("in controler createExamsForBranch branchId "+branchId);
    		return ResponseEntity.ok(examsServices.createExamsForBranch(branchId));
    } 
    
    @GetMapping("/getStAttExamResultsByBranchStdExam/{branchId}/{standardId}/{examId}/{stRollNo}")
    public ResponseEntity<List<ExamsModel>> getStAttExamResultsByBranchStdExam(@PathVariable String branchId, @PathVariable String standardId, @PathVariable String examId,@PathVariable String stRollNo) {
    	
    	System.out.println("in controler createExamsForBranch branchId "+branchId);
		return ResponseEntity.ok(examsServices.getStAttExamResultsByBranchStdExam(branchId,standardId,examId,stRollNo));
    	
    }
    
}
