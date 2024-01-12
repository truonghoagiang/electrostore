package com.example.electrostore.controller;
import com.example.electrostore.services.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestParam String email, @RequestParam String password) {

        String message = userServiceImp.save(email,password) ? "Thêm thành công" : "Thêm thất bại ";
        return new ResponseEntity<>( message, HttpStatus.OK);
    }

}
