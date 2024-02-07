package com.example.electrostore.controller;
import com.example.electrostore.jwt.JwtHelper;
import com.example.electrostore.payload.response.BasicResponse;
import com.google.gson.Gson;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
@CrossOrigin
@RequestMapping("/login")
@RestController
public class LoginController {
    private Gson gson = new Gson();
    private Logger logger = LoggerFactory.getLogger(LoginController.class);//thế systerm.out
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @PostMapping("")
    public ResponseEntity<?> login(@RequestParam String username,@RequestParam String password) {
        logger.info("Request username: "+username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
        //buoc de chung thuc dang nhap thanh cong
        Authentication authentication= authenticationManager.authenticate(token);

        String json= gson.toJson(authentication.getAuthorities());

        System.out.println(json);
        String jwttoken = jwtHelper.generateToken(json);

        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setData(jwttoken);


        logger.info("Response:"+jwttoken);
        return new ResponseEntity<>(basicResponse, HttpStatus.OK);
    }
    @PostMapping("signin")
    public ResponseEntity<?> login1(@RequestParam String token) {

        String data = jwtHelper.decodeToken(token);

        return new ResponseEntity<>(data , HttpStatus.OK);
    }
}
