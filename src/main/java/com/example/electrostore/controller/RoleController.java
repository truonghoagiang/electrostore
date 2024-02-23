package com.example.electrostore.controller;

import com.example.electrostore.dto.RoleDTO;
import com.example.electrostore.entity.RoleEntity;
import com.example.electrostore.payload.response.BasicResponse;
import com.example.electrostore.services.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleServiceImp roleServiceImp;

    @PostMapping("/add-role")
    public ResponseEntity<?> addRole(@RequestParam String name, String desc){
        roleServiceImp.save(name, desc);

        return new ResponseEntity<>("Insert suscessfull!", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllRole(Model model){
        List<RoleDTO> listRole = roleServiceImp.getAllRole();
        model.addAttribute("role", listRole);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setData(listRole);
        return new ResponseEntity<>(basicResponse, HttpStatus.OK);

    }
}
