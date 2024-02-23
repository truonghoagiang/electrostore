package com.example.electrostore.repository;

import com.example.electrostore.dto.UserDTO;
import com.example.electrostore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
@Repository
public interface UserRepository extends JpaRepository <UserEntity, Integer>{

}
