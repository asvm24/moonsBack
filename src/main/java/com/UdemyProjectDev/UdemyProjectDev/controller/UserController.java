package com.UdemyProjectDev.UdemyProjectDev.controller;

import com.UdemyProjectDev.UdemyProjectDev.dto.UserDto;
import com.UdemyProjectDev.UdemyProjectDev.model.User;
import com.UdemyProjectDev.UdemyProjectDev.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

// TODO : stop taking email as param that's cringe

    // TODO : make sure only someone with admin role can access these controllers

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/users")
@Log4j2
public class UserController {

    @Autowired
    private UserService userService;

    // TODO : you have to adapt this to return the appropriate server responses and get the appropriate server request
    // TODO : you have to map this because you can't be returning all the user data to the web server
    @PostMapping
    public User createUser(@RequestBody UserDto createUserRequest) {
        log.info("Recieved a request" + createUserRequest.toString());
//        TODO : when you create the user send them a mail telling them to set their password
        return userService.createUser(createUserRequest.getEmail(), createUserRequest.getRole(), createUserRequest.getPhoneNumber());
    }

    // TODO : don't take in the email as param

    @DeleteMapping("/{email}")
    public User deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody Map<String, Object> updates) {
        User updatedUser = userService.updateUser(email, updates);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

}

