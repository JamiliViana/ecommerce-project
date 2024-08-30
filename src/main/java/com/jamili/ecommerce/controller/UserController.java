package com.jamili.ecommerce.controller;

import com.jamili.ecommerce.models.User;
import com.jamili.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @PutMapping(value = "/{idUser}")
//    @ResponseStatus(HttpStatus.OK)
//    public User editUser(@PathVariable int idUser, @Valid  @RequestBody UserDTO user){
//        return userService.updateUser(idUser,user.transformToUser(user));
//    }

//    @DeleteMapping(value = "/{idUser}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteUser(@PathVariable int idUser){
//        userService.deleteUser(idUser);
//    }
}
