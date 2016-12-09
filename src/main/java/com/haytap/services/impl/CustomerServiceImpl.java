package com.haytap.services.impl;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.haytap.models.Customer;
import com.haytap.services.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	//@Autowired
    //protected RestTemplate rest;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@SuppressWarnings("unchecked")
	@Override
    public List<Customer> loadCustomers() {
        String resource = "http://localhost:8081/customer/";
        return restTemplate().getForObject(resource, List.class);
    }

}
