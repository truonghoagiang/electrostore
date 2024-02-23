package com.example.electrostore.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {
    private int id;
    private String name;
    private String desc;
}
