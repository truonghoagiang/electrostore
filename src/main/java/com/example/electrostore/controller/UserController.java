package com.example.electrostore.controller;
import com.example.electrostore.payload.response.BasicResponse;
import com.example.electrostore.services.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {

        String message = userServiceImp.save(name,email,password) ? "Thêm thành công" : "Thêm thất bại ";
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setData(message);
        System.out.println(message);
        return new ResponseEntity<>( basicResponse, HttpStatus.OK);
    }

}
