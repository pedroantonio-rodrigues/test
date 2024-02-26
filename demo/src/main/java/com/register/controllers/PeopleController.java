package com.register.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.domain.People;
import com.register.services.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/{peopleId}")
	public ResponseEntity<People> getPeople(@PathVariable Long peopleId){
		People people = peopleService.getPeopleById(peopleId);
		return ResponseEntity.ok(people);
	}
	
	 @PostMapping
	    public ResponseEntity<People> createPeople(@RequestBody People people) {
	        People createdPeople = peopleService.createPeople(people);
	        return ResponseEntity.ok(createdPeople);
	    }
	 
	  @GetMapping
	    public ResponseEntity<List<People>> getAllPeople() {
	        List<People> peopleList = peopleService.getAllPeople();
	        return ResponseEntity.ok(peopleList);
	    }
	  
	  @PutMapping("/{peopleId}")
	    public ResponseEntity<People> updatePeople(@PathVariable Long peopleId, @RequestBody People people) {
	        People updatedPeople = peopleService.updatePeople(peopleId, people);
	        return ResponseEntity.ok(updatedPeople);
	    }
	  
	   @DeleteMapping("/{peopleId}")
	    public ResponseEntity<Void> deletePeople(@PathVariable Long peopleId) {
	        peopleService.deletePeople(peopleId);
	        return ResponseEntity.noContent().build();
	    }
	
}
