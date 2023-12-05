package com.example.demo.tools;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

//    private static final String SECRET_KEY = "yourSecretKey"; // 替换为实际的密钥
    private static final String SECRET_KEY = "asdhuasudh12389789quea8sdahs823uajsid89q3hduwdidq89wada9d8a2ndasdhuasudh12389789quea8sdahs823uajsid89q3hduwdidq89wada9d8a2nd";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days, in milliseconds

    public static String generateToken(Integer userId,String username, Integer role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .claim("user_id", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
