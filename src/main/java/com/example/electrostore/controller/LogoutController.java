package com.example.electrostore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping("")
    public ResponseEntity<?> logout(@RequestParam String username) {

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
