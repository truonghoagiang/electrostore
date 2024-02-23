package com.example.electrostore.controller;

import com.example.electrostore.dto.ProductDTO;
import com.example.electrostore.payload.response.BasicResponse;
import com.example.electrostore.services.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(
            @RequestParam MultipartFile image,
            @RequestParam String title,
            @RequestParam double import_price,
            @RequestParam double retail_price,
            @RequestParam String color,
            @RequestParam int storage,
            @RequestParam int memory,
            @RequestParam int quantity,
            @RequestParam String import_date,
            @RequestParam int idCategory
    ) throws ParseException {
        productServiceImp.saveProduct(image, title, import_price, retail_price, color,
                storage, memory, quantity, import_date, idCategory);

        return new ResponseEntity<>("Insert suscessfull!", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllProduct(Model model){
        List<ProductDTO> listProduct = productServiceImp.getAllProduct();
        model.addAttribute(listProduct);
        BasicResponse basicResponse = new BasicResponse();
        basicResponse.setData(listProduct);
        return new ResponseEntity<>(basicResponse, HttpStatus.OK);
    }
}
