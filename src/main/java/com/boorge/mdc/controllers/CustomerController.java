package com.boorge.mdc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boorge.mdc.entities.Customer;
import com.boorge.mdc.services.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService custService;

	@GetMapping
	public List<Customer> getEmployees() {

		return custService.getAll();
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id) {
		return custService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@RequestBody @Valid Customer customer) {
		return custService.save(customer);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Customer update(@PathVariable("id") Long id, @RequestBody @Valid Customer customer) {
		Customer updateCustomer = custService.getById(id);
		updateCustomer = customer;
		return custService.save(updateCustomer);
	}

	@PatchMapping(path = "/{id}")
	public Customer partialUpdate(@PathVariable("id") Long id, @RequestBody @Valid Customer patchCustomer) {
		Customer updateCustomer = custService.getById(id);

		if (patchCustomer.getFirstName() != null)
			updateCustomer.setFirstName(patchCustomer.getFirstName());
		if (patchCustomer.getLastName() != null)
			updateCustomer.setLastName(patchCustomer.getLastName());
		if (patchCustomer.getEmail() != null)
			updateCustomer.setEmail(patchCustomer.getEmail());
		if (patchCustomer.getPhone1() != null)
			updateCustomer.setPhone1(patchCustomer.getPhone1());
		if (patchCustomer.getPhone2() != null)
			updateCustomer.setPhone2(patchCustomer.getPhone2());
		if (patchCustomer.getRegister() != null)
			updateCustomer.setRegister(patchCustomer.getRegister());
		if (patchCustomer.getBirthday() != null)
			updateCustomer.setBirthday(patchCustomer.getBirthday());
		if (patchCustomer.getAddress1() != null)
			updateCustomer.setAddress1(patchCustomer.getAddress1());
		if (patchCustomer.getAddress2() != null)
			updateCustomer.setAddress2(patchCustomer.getAddress2());
		if (patchCustomer.getCity() != null)
			updateCustomer.setCity(patchCustomer.getCity());
		if (patchCustomer.getProvince() != null)
			updateCustomer.setProvince(patchCustomer.getProvince());
		if (patchCustomer.getCountry() != null)
			updateCustomer.setCountry(patchCustomer.getCountry());
		if (patchCustomer.getGender() != null)
			updateCustomer.setGender(patchCustomer.getGender());

		return custService.save(updateCustomer);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			custService.delete(id);
		} catch (EmptyResultDataAccessException e) {

		}
	}

	@GetMapping(params = { "page", "size" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Iterable<Customer> findPaginatedCustomers(@RequestParam("page") int page, @RequestParam("size") int size) {
		Pageable pageAndSize = PageRequest.of(page, size);
		return custService.getAll(pageAndSize);
	}

}
