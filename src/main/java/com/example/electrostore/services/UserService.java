package com.example.electrostore.services;

import com.example.electrostore.dto.UserDTO;
import com.example.electrostore.entity.RoleEntity;
import com.example.electrostore.entity.UserEntity;
import com.example.electrostore.repository.RoleRepository;
import com.example.electrostore.repository.UserRepository;
import com.example.electrostore.services.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> listUser = userRepository.findAll();
        List<UserDTO> userDTO = new ArrayList<>();
        for(UserEntity item : listUser){
            UserDTO user = new UserDTO();
            user.setId(item.getId());
            user.setFullname(item.getFullname());
            user.setEmail(item.getEmail());
            user.setPassword(item.getPassword());
            user.setPhone(item.getPhone());
            user.setRole(item.getRole().getName());

            userDTO.add(user);
        }
        return userDTO;
    }

    @Override
    public void saveUser(String fullname, String email, String password,String phone, int idRole) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFullname(fullname);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setPhone(phone);

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(idRole);
        userEntity.setRole(roleEntity);

        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


}
