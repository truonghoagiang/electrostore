package com.example.electrostore.services.imp;

import com.example.electrostore.dto.UserDTO;
import com.example.electrostore.entity.UserEntity;

import java.util.List;

public interface UserServiceImp {
    List<UserDTO> getAllUser();

    void saveUser(String fullname, String username, String password, String phone, int idRole);
    void deleteUser(int id);
}
