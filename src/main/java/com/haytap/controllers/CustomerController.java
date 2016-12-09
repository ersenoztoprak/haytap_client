package com.haytap.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.haytap.models.Customer;
import com.haytap.services.CustomerService;
import com.haytap.util.SessionScoped;

@SessionScoped
public class CustomerController {

	private List<Customer> customers;
	
	@Autowired
	private CustomerService customerService;
	
	@PostConstruct
	public void init() {
		customers = customerService.loadCustomers();
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
}
