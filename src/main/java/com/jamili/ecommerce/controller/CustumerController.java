package com.jamili.ecommerce.controller;

import com.jamili.ecommerce.models.Customer;
import com.jamili.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustumerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer registerCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @PutMapping(value = "/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    public Customer editCustomer(@PathVariable int idCustomer, @RequestBody Customer customer){
        return customerService.updateCustomer(idCustomer, customer);
    }

    @DeleteMapping(value = "/{idCustomer}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable int idCustomer){
        customerService.deleteCustomer(idCustomer);
    }

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Customer findCustomerByEmail(@PathVariable String email){
        return customerService.findCustomerByEmail(email);
    }
}
