package com.example.electrostore.services;

import com.example.electrostore.dto.ProductDTO;
import com.example.electrostore.entity.CategoryEntity;
import com.example.electrostore.entity.ProductEntity;
import com.example.electrostore.repository.ProductRepository;
import com.example.electrostore.services.imp.FileSaveImp;
import com.example.electrostore.services.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.spring6.processor.SpringUErrorsTagProcessor;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService implements ProductServiceImp {

    @Autowired
    private FileSaveImp fileSaveImp;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void saveProduct(MultipartFile file, String title, double import_price,
                     double retail_price, String color, int storate, int memory,
                     int quantity, String import_date, int id_category) throws ParseException {

        fileSaveImp.saveImage(file);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setImage(file.getOriginalFilename());
        productEntity.setTitle(title);
        productEntity.setImport_price(import_price);
        productEntity.setRetail_price(retail_price);
        productEntity.setColor(color);
        productEntity.setStorage(storate);
        productEntity.setMemory(memory);
        productEntity.setQuantity(quantity);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse(import_date);
        dateFormat.applyPattern("yyyy/MM/dd");
        productEntity.setImport_date(dateFormat.format(date));

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(id_category);
        productEntity.setCategory(categoryEntity);

        productRepository.save(productEntity);
    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> listProduct = productRepository.findAll();
        List<ProductDTO> productDTO = new ArrayList<>();
        for(ProductEntity item : listProduct){
            ProductDTO product = new ProductDTO();
            product.setImage("http://localhost:8080/api/file/" + item.getImage());
            product.setTitle(item.getTitle());
            product.setImport_price(item.getImport_price());
            product.setRetail_price(item.getRetail_price());
            product.setColor(item.getColor());
            product.setStorage(item.getStorage());
            product.setMemory(item.getMemory());
            product.setQuantity(item.getQuantity());
            product.setImport_date(item.getImport_date());
            product.setCategory(item.getCategory().getName());
            productDTO.add(product);
        }

        return productDTO;
    }

}
