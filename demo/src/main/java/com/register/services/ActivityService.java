package com.register.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.domain.Activity;
import com.register.repositories.ActivityRepository;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	  public Activity getActivityById(Long activityId) {
	        Optional<Activity> activityOptional = activityRepository.findById(activityId);
	        return activityOptional.orElse(null);
	    }
	    public List<Activity> getAllActivities() {
	        return activityRepository.findAll();
	    }
	    public Activity createActivity(Activity activity) {
	        // Defina a data de criação antes de salvar a atividade
	        activity.setCreationDate(new Date());
	        
	        // Implementar lógica para validar e salvar a atividade no banco de dados
	        return activityRepository.save(activity);
	    }
	    
	    public Activity updateActivity(Long activityId, Activity updatedActivity) {
	        // Implementar lógica para atualizar a atividade no banco de dados
	        Optional<Activity> existingActivityOptional = activityRepository.findById(activityId);

	        if (existingActivityOptional.isPresent()) {
	            Activity existingActivity = existingActivityOptional.get();
	            existingActivity.setDescription(updatedActivity.getDescription());
	            existingActivity.setStart(updatedActivity.getStart());
	            existingActivity.setEnd(updatedActivity.getEnd());
	            // ... atualize outros campos conforme necessário

	            return activityRepository.save(existingActivity);
	        } else {
	            return null; // Atividade não encontrada
	        }
	    }
	    
	    public void deleteActivity(Long activityId) {
	        // Implementar lógica para excluir a atividade do banco de dados
	        activityRepository.deleteById(activityId);
	    }
}
