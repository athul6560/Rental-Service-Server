package com.zeezaglobal.Rental.Car.Z.controller;

import com.zeezaglobal.Rental.Car.Z.entities.Users;
import com.zeezaglobal.Rental.Car.Z.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rentals/users")
public class AuthenticationController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(@RequestBody Users users) {
        Users savedUser = null;
        ResponseEntity response = null;
        try {
            savedUser = userRepository.save(users);
            if (savedUser.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error:" + e.getMessage());
        }
        return response;
    }

    @GetMapping(path = "/all")
    public @ResponseBody String getAllUsers() {

        return "ALl";
    }
}
