package com.register.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>{

}
