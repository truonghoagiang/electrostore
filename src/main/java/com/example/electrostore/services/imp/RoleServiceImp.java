package com.example.electrostore.services.imp;

import com.example.electrostore.dto.RoleDTO;

import java.util.List;

public interface RoleServiceImp {

    List<RoleDTO> getAllRole();

    void save(String name, String desc);
}
