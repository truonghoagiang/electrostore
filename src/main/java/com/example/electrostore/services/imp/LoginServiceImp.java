package com.example.electrostore.services.imp;

import com.example.electrostore.entity.UserEntity;

public interface LoginServiceImp {
    public UserEntity checkLogin(String username, String password);
}
