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

import com.register.domain.Address;
import com.register.services.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{addressId}")
	public ResponseEntity<Address> getAddress(@PathVariable Long addressId){
		Address address = addressService.getAddressById(addressId);
		return ResponseEntity.ok(address);
	}
	
	@PostMapping
	  public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        Address createdAddress = addressService.createAddress(address);
        return ResponseEntity.ok(createdAddress);
    }
	
	 @PutMapping("/{addressId}")
	    public ResponseEntity<Address> updateAddress(@PathVariable Long addressId, @RequestBody Address address) {
	        Address updatedAddress = addressService.updateAddress(addressId, address);
	        return ResponseEntity.ok(updatedAddress);
	    }

	  @DeleteMapping("/{addressId}")
	    public ResponseEntity<Void> deleteAddress(@PathVariable Long addressId) {
	        addressService.deleteAddress(addressId);
	        return ResponseEntity.noContent().build();
	    }
	

}
