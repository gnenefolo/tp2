package com.example.demoapp.controller;

import com.example.demoapp.dto.UserDto;
import com.example.demoapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        return ResponseEntity.ok(service.create(user));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable ("id") Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id") Long id){
        service.delete(id);
        String message = String.format("The user with id %d has been deleted", id);
        return ResponseEntity.ok(message);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(
            @RequestBody UserDto userDto,
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(service.update(id, userDto));
    }
}
