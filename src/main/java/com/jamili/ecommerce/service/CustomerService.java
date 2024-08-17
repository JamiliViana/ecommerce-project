package com.jamili.ecommerce.service;

import com.jamili.ecommerce.config.exceptions.CustomerAlreadyExistsException;
import com.jamili.ecommerce.config.exceptions.CustumerNotFoundException;
import com.jamili.ecommerce.models.Customer;
import com.jamili.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer newCustomer){
        Iterable<Customer> customers = getAllCustomers();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(newCustomer.getEmail())) {
                throw new CustomerAlreadyExistsException(newCustomer.getEmail());
            }
            if (customer.getCpf().equals(newCustomer.getCpf())) {
                throw new CustomerAlreadyExistsException(newCustomer.getCpf());
            }
        }
        return customerRepository.save(newCustomer);
    }

    public Customer findCustomerById (int customerId){
        Customer customerResult = this.customerRepository.findById(customerId);
        if (customerResult == null) {throw new CustumerNotFoundException(customerId);}
        return customerResult;
    }

    public Customer updateCustomer(int customerId, Customer customerUpdated){
        Customer customerToUpdate = findCustomerById(customerId);
        customerToUpdate.setAddress(customerUpdated.getAddress());
        customerToUpdate.setMobile(customerUpdated.getMobile());
        customerToUpdate.setEmail(customerUpdated.getEmail());
        customerToUpdate.setCostumerName(customerUpdated.getCostumerName());
        return this.customerRepository.save(customerToUpdate);
    }

    public void deleteCustomer(int cusotmerId){
        Customer customerToDelete = this.findCustomerById(cusotmerId);
        this.customerRepository.delete(customerToDelete);
    }

    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerByEmail(String email) {
        Customer customerResult = customerRepository.findByEmail(email);
        if (customerResult == null) {throw new CustumerNotFoundException(email);}
        return customerResult;
    }


}
