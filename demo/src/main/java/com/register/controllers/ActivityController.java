package com.register.controllers;

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

import com.register.domain.Activity;
import com.register.services.ActivityService;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/{activityId}")
	public ResponseEntity<Activity> getActivity(@PathVariable Long activityId){
		Activity activity = activityService.getActivityById(activityId);
		return ResponseEntity.ok(activity);
	}
	
	
	  @PostMapping
	    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
	        Activity createdActivity = activityService.createActivity(activity);
	        return ResponseEntity.ok(createdActivity);
	    }
	  
	   @PutMapping("/{activityId}")
	    public ResponseEntity<Activity> updateActivity(@PathVariable Long activityId, @RequestBody Activity activity) {
	        Activity updatedActivity = activityService.updateActivity(activityId, activity);
	        return ResponseEntity.ok(updatedActivity);
	    }
	   
	   @DeleteMapping("/{activityId}")
	    public ResponseEntity<Void> deleteActivity(@PathVariable Long activityId) {
	        activityService.deleteActivity(activityId);
	        return ResponseEntity.noContent().build();
	    }
	
	
	
	
	}

