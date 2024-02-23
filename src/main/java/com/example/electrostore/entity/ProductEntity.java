package com.example.electrostore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image")
    private String image;

    @Column(name = "title")
    private String title;

    @Column(name = "import_price")
    private double import_price;

    @Column(name = "price")
    private double retail_price;

    @Column(name = "color")
    private String color;

    @Column(name = "storage")
    private int storage;

    @Column(name = "memory")
    private int memory;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "import_date")
    private String import_date;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryEntity category;


}
