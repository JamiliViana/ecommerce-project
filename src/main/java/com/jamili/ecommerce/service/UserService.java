package com.jamili.ecommerce.service;

import com.jamili.ecommerce.config.exceptions.UserAlreadyExistsException;
import com.jamili.ecommerce.config.exceptions.UserNotFoundException;
import com.jamili.ecommerce.models.User;
import com.jamili.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser){
        Iterable<User> users = getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(newUser.getEmail())) {
                throw new UserAlreadyExistsException(newUser.getEmail());
            }
            if (user.getCpf().equals(newUser.getCpf())) {
                throw new UserAlreadyExistsException(newUser.getCpf());
            }
        }
        return userRepository.save(newUser);
    }

    public User findUserById(int userId){
        User userResult = this.userRepository.findById(userId);
        if (userResult == null) {throw new UserNotFoundException(userId);}
        return userResult;
    }

    public User updateUser(int userId, User userUpdated){
        User userToUpdate = findUserById(userId);
        userToUpdate.setAddress(userUpdated.getAddress());
        userToUpdate.setMobile(userUpdated.getMobile());
        userToUpdate.setEmail(userUpdated.getEmail());
        userToUpdate.setUsername(userUpdated.getUsername());
        return this.userRepository.save(userToUpdate);
    }

    public void deleteUser(int userId){
        User userToDelete = this.findUserById(userId);
        this.userRepository.delete(userToDelete);
    }

    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        User userResult = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
        if (userResult == null) {throw new UserNotFoundException(email);}
        return userResult;
    }


}
