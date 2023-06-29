package com.eDairy.services.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eDairy.services.model.Subjects;
import com.eDairy.services.services.SubjectsService;

@RestController
@RequestMapping("/v1/Subjects")
public class SubjectsController {

	private final SubjectsService SubjectsService;

	public SubjectsController(SubjectsService SubjectsService) {
		this.SubjectsService = SubjectsService;

	}

	@GetMapping("/Subjects/{SubjectsId}")
	public List<Subjects> getSubjectsById(@PathVariable String subjectsId) {
		return SubjectsService.getSubjectsById(subjectsId);
	}

	@GetMapping("/findAllSubjects")
	public List<Subjects> getAllSubjects() {
		return SubjectsService.getAllSubjects();
	}

	@PostMapping("/saveSubjects")
	public Subjects saveSubjects(@RequestBody Subjects subjects) {

		return SubjectsService.saveSubjects(subjects);

	}
	
	@PostMapping("/deleteSubjects")
	public void deleteSubjects(@RequestBody Subjects subjects) {

		 SubjectsService.deleteSubjects(subjects);

	}
	

}
