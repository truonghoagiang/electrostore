package com.example.electrostore.services;

import com.example.electrostore.dto.CategoryDTO;
import com.example.electrostore.entity.CategoryEntity;
import com.example.electrostore.repository.CategoryRepository;
import com.example.electrostore.services.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void saveCategory(String name, String desc) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(name);
        categoryEntity.setDesc(desc);
        categoryRepository.save(categoryEntity);

    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryDTO> listCategoryDTO = new ArrayList<>();
        for(CategoryEntity item : list){
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(item.getId());
            categoryDTO.setName(item.getName());
            categoryDTO.setDesc(item.getDesc());

            listCategoryDTO.add(categoryDTO);
        }
        return listCategoryDTO;
    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
