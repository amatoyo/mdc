package com.boorge.mdc.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.boorge.mdc.entities.Customer;

@RepositoryRestResource(collectionResourceRel="customers", path="customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	
	@Override
	public List<Customer> findAll();

}
