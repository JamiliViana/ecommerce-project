package com.jamili.ecommerce.repository;

import com.jamili.ecommerce.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    User findById(int id);
    Optional<User> findByUsername(String username);

}
