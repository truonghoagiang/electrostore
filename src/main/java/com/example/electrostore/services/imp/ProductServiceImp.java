package com.example.electrostore.services.imp;

import com.example.electrostore.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

public interface ProductServiceImp {
    void saveProduct(MultipartFile file, String title,
              double import_price, double retail_price,
              String color, int storate, int memory,
              int quantity, String import_date, int id_category) throws ParseException;

    List<ProductDTO> getAllProduct();

}


