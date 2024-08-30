package com.jamili.ecommerce.service;

import com.jamili.ecommerce.config.exceptions.InvalidCredentialsException;
import com.jamili.ecommerce.config.exceptions.UserAlreadyExistsException;
import com.jamili.ecommerce.config.exceptions.UserNotFoundException;
import com.jamili.ecommerce.dto.LoginRequestDTO;
import com.jamili.ecommerce.dto.RegisterRequestDTO;
import com.jamili.ecommerce.dto.ResponseDTO;
import com.jamili.ecommerce.models.User;
import com.jamili.ecommerce.repository.UserRepository;
import com.jamili.ecommerce.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    public ResponseDTO register(RegisterRequestDTO body){
        Optional<User> user = this.userRepository.findByEmail(body.email());

        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setUsername(body.name());
            newUser.setRole("ROLE_USER");
            newUser.setAddress(body.address());
            newUser.setCpf(body.cpf());
            newUser.setMobile(body.mobile());
            this.userRepository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return new ResponseDTO(newUser.getUsername(), token);
        }
        throw new UserAlreadyExistsException(body.email());
    }

    public ResponseDTO login(LoginRequestDTO loginRequest) {
        User user = this.userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new UserNotFoundException(loginRequest.email()));

        if (passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            String token = tokenService.generateToken(user);
            return new ResponseDTO(user.getUsername(), token);
        }
        throw new InvalidCredentialsException();
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

    public User findUserByEmail(String email) {
        User userResult = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
        if (userResult == null) {throw new UserNotFoundException(email);}
        return userResult;
    }


}
