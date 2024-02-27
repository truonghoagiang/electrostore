package com.example.electrostore.controller;

import com.example.electrostore.dto.RoleDTO;
import com.example.electrostore.dto.UserDTO;
import com.example.electrostore.entity.RoleEntity;
import com.example.electrostore.entity.UserEntity;
import com.example.electrostore.payload.response.BasicResponse;
import com.example.electrostore.repository.RoleRepository;
import com.example.electrostore.repository.UserRepository;
import com.example.electrostore.services.imp.RoleServiceImp;
import com.example.electrostore.services.imp.UserServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private RoleServiceImp roleServiceImp;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin
    @PostMapping("/add-user")
    public ResponseEntity<?> createUser(
            @RequestParam String fullname,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam int idRole){

        userServiceImp.saveUser(fullname, email, password, phone, idRole);
        logger.info("Kiem tra data: " + fullname +"-"+ email +"-"+ password+"-" + phone+"-" + idRole);
        return new ResponseEntity<>("Insert Suscessfull!", HttpStatus.OK);

    }

    @GetMapping("/add-user")
    public ResponseEntity<?> loadFormAddUser(Model model){
        List<RoleDTO> listRole = roleServiceImp.getAllRole();
        model.addAttribute("role",listRole);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setData(listRole);
        return new ResponseEntity<>(basicResponse,HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(Model model){
        List<UserDTO> listUser = userServiceImp.getAllUser();
        model.addAttribute("listuser", listUser);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setData(listUser);
        return new ResponseEntity<>(basicResponse, HttpStatus.OK);
    }

    @DeleteMapping( "/delete/{id}")
    public String deleteUser(@PathVariable int id){
        userServiceImp.deleteUser(id);
        return new String("Delete complete");
    }
}
