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
import com.eDairy.services.services.ExamsResultsService;

@RestController
@RequestMapping("/v1/examResults")
public class ExamsResultsController {

    private final ExamsResultsService examsResultsService;

    public ExamsResultsController(ExamsResultsService examsResultsService) {
        this.examsResultsService = examsResultsService;
    }

    @GetMapping("/getAllExams")
    public ResponseEntity<List<ExamResults>> getAllExamsResults(){
    		return ResponseEntity.ok(examsResultsService.getAllExamsResults());
    }
    
    @PostMapping("/saveExam")
    public ResponseEntity<ExamResults> saveExam(@RequestBody  ExamResults examResults ){
    System.out.println("in controler examResults "+examResults);
    		return ResponseEntity.ok(examsResultsService.saveExamResults(examResults));
    }
    
    @PostMapping("/createExamsResultsForBranch/{branchId}")
    public ResponseEntity<List<ExamResults>> createExamsResultsForBranch(@PathVariable  String branchId ){
    System.out.println("in controler createExamsResultsForBranch branchId "+branchId);
    		return ResponseEntity.ok(examsResultsService.createExamsResultsForBranch(branchId));
    }    
}
