package com.zeezaglobal.Rental.Car.Z.controller;

import com.zeezaglobal.Rental.Car.Z.entities.Users;
import com.zeezaglobal.Rental.Car.Z.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rentals/users")
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email,@RequestParam String password) {


        Users n = new Users();

        n.setName(name);
        n.setEmail(email);
        n.setPassword(passwordEncoder.encode(password));
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Users> getAllUsers() {

        return userRepository.findAll();
    }
}
