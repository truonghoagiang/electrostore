package com.example.electrostore.services;

import com.example.electrostore.entity.UserEntity;
import com.example.electrostore.repository.UserRepository;
import com.example.electrostore.services.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Override
    public UserEntity checkLogin(String username,String password) {
        UserEntity userEntity = userRepository.findByEmail(username);
        if (userEntity != null&&passwordEncoder.matches(password, userEntity.getPassword())) {
            return userEntity;
        }
             return null;

    }
}
