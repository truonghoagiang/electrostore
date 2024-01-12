package com.example.electrostore.services.imp;

import com.example.electrostore.entity.UserEntity;

public interface UserServiceImp {
    boolean findByEmail(String email);
    boolean save(String email,String password);

}
