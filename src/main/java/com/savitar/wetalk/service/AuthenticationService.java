package com.savitar.wetalk.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.savitar.wetalk.entity.User;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class AuthenticationService {
    public String getToken(User user) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(user.getNickname().toString())
                    .sign(Algorithm.HMAC256(user.getPassword()));
        } catch (UnsupportedEncodingException ignore) {

        }
        return token;
    }
}
