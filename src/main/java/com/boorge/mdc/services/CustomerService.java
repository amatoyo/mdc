package com.boorge.mdc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boorge.mdc.entities.Customer;
import com.boorge.mdc.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	
	public List<Customer> getAll(){
		return custRepo.findAll();
	}
	
	public Customer getById(Long id) {
		return custRepo.findById(id).get();
	}
	
	public Customer save(Customer customer) {
		return custRepo.save(customer);
	}
	
	public void delete(Long id) {
		custRepo.deleteById(id);
	}
	
	public Iterable<Customer> getAll(Pageable page){
		return custRepo.findAll(page);
	}
}
