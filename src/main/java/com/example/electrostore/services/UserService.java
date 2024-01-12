package com.example.electrostore.services;

import com.example.electrostore.entity.UserEntity;
import com.example.electrostore.repository.UserRepository;
import com.example.electrostore.services.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean findByEmail(String email) {
        Optional<UserEntity> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        return userOptional.isPresent();
    }
    @Override
    public boolean save(String email, String password) {
        boolean isSave = false;
        UserEntity userEntity = new UserEntity();
        if (!findByEmail(email)) {
            userEntity.setEmail(email);
            userEntity.setPassword(password);
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
