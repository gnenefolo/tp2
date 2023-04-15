package com.example.demoapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;


    @GetMapping("/get-all")
    public Iterable<User> getAllUser(){
        userRepository.saveAll(
                Arrays.asList(
                        new User(1L, "samuel"),
                        new User(2L, "Wilfried"),
                        new User(3L, "Marcel"),
                        new User(4L, "Anwar")
                )
        );
        return userRepository.findAll();
    }
}
