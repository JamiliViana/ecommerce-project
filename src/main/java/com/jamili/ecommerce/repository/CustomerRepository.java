package com.jamili.ecommerce.repository;

import com.jamili.ecommerce.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByEmail(String email);

    Customer findById(int id);

}
