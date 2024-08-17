package com.jamili.ecommerce.repository;

import com.jamili.ecommerce.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
