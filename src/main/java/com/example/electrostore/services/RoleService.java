package com.example.electrostore.services;

import com.example.electrostore.dto.RoleDTO;
import com.example.electrostore.entity.RoleEntity;
import com.example.electrostore.repository.RoleRepository;
import com.example.electrostore.services.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements RoleServiceImp {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRole() {
        List<RoleEntity> listRole = roleRepository.findAll();
        List<RoleDTO> listroleDTO = new ArrayList<>();
        for(RoleEntity item : listRole){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(item.getId());
            roleDTO.setName(item.getName());
            roleDTO.setDesc(item.getDesc());

            listroleDTO.add(roleDTO);
        }
        return listroleDTO;
    }

    @Override
    public void save(String name, String desc) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName(name);
        roleEntity.setDesc(desc);
        roleRepository.save(roleEntity);
    }
}
