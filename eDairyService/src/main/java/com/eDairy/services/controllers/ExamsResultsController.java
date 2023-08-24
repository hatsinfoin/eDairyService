package com.eDairy.services.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.ExamResults;
import com.eDairy.services.model.StudentAttendance;
import com.eDairy.services.model.StudentAttendenceStatus;
import com.eDairy.services.services.ExamsResultsService;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

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
    
    @GetMapping("/getAllStuentResultsbasedOnBranch/{branchId}/{standardId}/{acadamicYear}")
   // public ResponseEntity<List<ExamResults>> searchExamResultsByRollNO(){
    	public ResponseEntity<List<ExamResults>> searchExamResultsByRollNO(@PathVariable String branchId, @PathVariable String standardId,@PathVariable String acadamicYear)
    	{	
    		return ResponseEntity.ok(examsResultsService.getAllStuentResultsbasedOnBranch(branchId,standardId,acadamicYear));
    		
    } 
    
    
    @GetMapping("/YearBranchStudntId/{branchId}/{standardId}/{stRollNo}")
    // public ResponseEntity<List<ExamResults>> searchExamResultsByRollNO(){
     	public ResponseEntity<List<ExamResults>> YearBranchStudntId(@PathVariable String branchId, @PathVariable String standardId,@PathVariable String stRollNo)
     	{	
     		return ResponseEntity.ok(examsResultsService.YearBranchStudntId(branchId,standardId,stRollNo));
     		
    
    
    
    }
    
    }

