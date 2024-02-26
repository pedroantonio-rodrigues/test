package com.register.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.register.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	

}
