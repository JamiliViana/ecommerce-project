package com.jamili.ecommerce.service;

import com.jamili.ecommerce.model.Customer;
import com.jamili.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }


}
