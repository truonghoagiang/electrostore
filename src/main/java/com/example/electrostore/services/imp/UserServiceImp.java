package com.example.electrostore.services.imp;

import com.example.electrostore.entity.UserEntity;

public interface UserServiceImp {
    boolean save(String name,String email,String password);

}
