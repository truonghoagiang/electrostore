package com.example.electrostore.services;

import com.example.electrostore.entity.RoleEntity;
import com.example.electrostore.entity.UserEntity;
import com.example.electrostore.repository.UserRepository;
import com.example.electrostore.services.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(String name,String email, String password) {
        boolean isSave = false;
        UserEntity userEntity = new UserEntity();
        if (userRepository.findByEmail(email)==null) {
            userEntity.setEmail(email);
            userEntity.setPassword( passwordEncoder.encode(password));
            RoleEntity userRole = new RoleEntity();
            userRole.setId(3);
            userEntity.setRole(userRole);
            try {
                userRepository.save(userEntity);
                isSave=true;
            } catch (Exception e) {
                throw new RuntimeException("Lỗi thêm user: " + e.getMessage());
            }
        }
        return isSave;
    }

}
