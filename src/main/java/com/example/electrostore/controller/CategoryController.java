package com.example.electrostore.controller;


import com.example.electrostore.dto.CategoryDTO;
import com.example.electrostore.entity.CategoryEntity;
import com.example.electrostore.payload.response.BasicResponse;
import com.example.electrostore.services.imp.CategoryServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    private Logger logger  = LoggerFactory.getLogger(CategoryController.class);
    @PostMapping("/add-category")
    public ResponseEntity<?> addNewCategory(@RequestParam String name, @RequestParam String desc){
        categoryServiceImp.saveCategory(name, desc);
        logger.info("Kiem tra du lieu:" + name + "-" + desc);
        return new ResponseEntity<>("Insert suscessfull", HttpStatus.OK);

    }

    @GetMapping("")
    public  ResponseEntity<?> getAllCategory(Model model){
        List<CategoryDTO> listCategory = categoryServiceImp.getAllCategory();
        model.addAttribute("category", listCategory);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setData(listCategory);
        return new ResponseEntity<>(basicResponse, HttpStatus.OK);
    }
}
