package com.example.electrostore.services.imp;

import com.example.electrostore.dto.CategoryDTO;

import java.util.List;

public interface CategoryServiceImp {
    void saveCategory(String name, String disc);

    List<CategoryDTO> getAllCategory();

    void deleteById(int id);
}
