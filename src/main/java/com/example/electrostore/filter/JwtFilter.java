package com.example.electrostore.filter;

import com.example.electrostore.jwt.JwtHelper;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
@Service
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtHelper jwtHelper;

    private Gson gson= new Gson();


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Kiểm tra filter");

        String bearerToken = request.getHeader("Authorization");
        Optional<String> tokenOptional = Optional.ofNullable(bearerToken);//Kieu dữ liệu optional, để check null giá trị cho dễ thôi
        System.out.println("Kiem tra token "+ bearerToken);
        if (tokenOptional.isPresent()) {
            String token = tokenOptional.get().substring(7);
            System.out.println("kiểm tra: " + token);
            if (token != null) {
                String data =  jwtHelper.decodeToken(token);
                // tạo ra customtype để gson hỗ trợ parse json kiểu List
                Type listType = new TypeToken<List<SimpleGrantedAuthority>>() {}.getType();
                List<GrantedAuthority> listRoles = gson.fromJson(data, listType);

                if (data != null) {
                    //Tạo contex Holder đẻ by pass qua các filter của security
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("","",listRoles);

                    SecurityContext securityContext = SecurityContextHolder.getContext();
                    securityContext.setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
