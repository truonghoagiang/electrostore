package com.example.electrostore.security;

import com.example.electrostore.entity.UserEntity;
import com.example.electrostore.services.LoginService;
import com.example.electrostore.services.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomAuthenProvider implements AuthenticationProvider {
    @Autowired
    private LoginServiceImp loginServiceImp;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username=(String) authentication.getPrincipal();
        String password = (String)authentication.getCredentials();
        UserEntity userEntity = loginServiceImp.checkLogin(username, password);

        if (userEntity!=null) {
            // tạo một list nhận vào  danh sách quyền theo chuẩn  của security
            List<GrantedAuthority> listRoles = new ArrayList<>();
            // tạo một quyền và gán tên quyền truy vấn được database để add vào list role ở trên
            SimpleGrantedAuthority role = new SimpleGrantedAuthority(userEntity.getRole().getName());
            listRoles.add(role);
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(username,"",listRoles);

            return authenticationToken;
        }
            return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
