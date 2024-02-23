package com.example.electrostore.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    //private int id;
    String image;
    private String title;
    private double import_price;
    private double retail_price;
    private String color;
    private int storage;
    private int memory;
    private int quantity;
    private String category;
    private String import_date;
}
