package com.register.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.domain.Address;
import com.register.repositories.AddressRepository;

@Service
public class AddressService {
	
	  @Autowired
	    private AddressRepository addressRepository;


	    public Address getAddressById(Long addressId) {
	        Optional<Address> addressOptional = addressRepository.findById(addressId);
	        return addressOptional.orElse(null);
	    }
	    
	    public Address createAddress(Address address) {
	        // Implementar lógica para validar e salvar o endereço no banco de dados
	        return addressRepository.save(address);
	    }
	    
	    public Address updateAddress(Long addressId, Address updatedAddress) {
	        // Implementar lógica para atualizar o endereço no banco de dados
	        Optional<Address> existingAddressOptional = addressRepository.findById(addressId);

	        if (existingAddressOptional.isPresent()) {
	            Address existingAddress = existingAddressOptional.get();
	            existingAddress.setStreet(updatedAddress.getStreet());
	            existingAddress.setCity(updatedAddress.getCity());
	            existingAddress.setNumber(updatedAddress.getNumber());
	            existingAddress.setComplement(updatedAddress.getComplement());
	            // ... atualize outros campos conforme necessário

	            return addressRepository.save(existingAddress);
	        } else {
	            return null; // Endereço não encontrado
	        }
	    }


	    public void deleteAddress(Long addressId) {
	        // Implementar lógica para excluir o endereço do banco de dados
	        addressRepository.deleteById(addressId);
	    }
	    
	    
}
