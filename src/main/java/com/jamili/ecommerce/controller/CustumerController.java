package com.jamili.ecommerce.controller;

import com.jamili.ecommerce.model.Customer;
import com.jamili.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustumerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping(value = "/{idCustomer}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable int idCustomer){
        Customer findCustomerById = customerService.findCustomerById(idCustomer);
        return  ResponseEntity.ok(findCustomerById);
    }

    @PutMapping(value = "/{idCustomer}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int idCustomer, @RequestBody Customer customer){
        Customer editedCustomer = customerService.updateCustomer(idCustomer, customer);
        return ResponseEntity.ok(editedCustomer);
    }

    @DeleteMapping(value = "/{idCustomer}")
    public ResponseEntity deleteCustomer(@PathVariable int idCustomer){
        customerService.deleteCustomer(idCustomer);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public Iterable<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
