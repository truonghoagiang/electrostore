package com.example.electrostore.jwt;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtHelper {
    @Value("${token.key}")
    private String strKey;
    private int expiredTime =24*60*60*1000;
    public String generateToken(String data) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));
        Date date = new Date();
        long futureMilis = date.getTime()+ expiredTime;
        System.out.println("Kiểm tra"+futureMilis);
        Date futureDate=  new Date(futureMilis);
        return Jwts.builder().subject(data).expiration(futureDate).signWith(key).compact();
    }

        public String decodeToken(String token) {
        String data=null;
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(strKey));
        try {
            data= Jwts.parser().verifyWith(key).build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (Exception e) {
            System.out.println("Lỗi parser token"+ e.getMessage());
        }
        return data;
    }
}
