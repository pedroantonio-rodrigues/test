package com.register.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.domain.People;
import com.register.repositories.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	public People getPeopleById(Long peopleId) {
		Optional<People> peopleOptional = peopleRepository.findById(peopleId);
		return peopleOptional.orElse(null);
	}
	
	  public List<People> getAllPeople() {
	        return peopleRepository.findAll();
	    }
	  
	   public People createPeople(People people) {
	        // Implementar lógica para validar e salvar a pessoa no banco de dados
	        return peopleRepository.save(people);
	    }
	   
	    public People updatePeople(Long peopleId, People updatedPeople) {
	        // Implementar lógica para atualizar a pessoa no banco de dados
	        Optional<People> existingPeopleOptional = peopleRepository.findById(peopleId);

	        if (existingPeopleOptional.isPresent()) {
	            People existingPeople = existingPeopleOptional.get();
	            existingPeople.setName(updatedPeople.getName());
	            existingPeople.setPhone(updatedPeople.getPhone());
	            existingPeople.setEmail(updatedPeople.getEmail());
	            // ... atualize outros campos conforme necessário

	            return peopleRepository.save(existingPeople);
	        } else {
	            return null; // Pessoa não encontrada
	        }
	    }
	    public void deletePeople(Long peopleId) {
	        // Implementar lógica para excluir a pessoa do banco de dados
	        peopleRepository.deleteById(peopleId);
	    }
	

}
