package com.jamili.ecommerce.repository;

import com.jamili.ecommerce.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
