package com.savitar.wetalk.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.savitar.wetalk.annotation.LoginRquired;
import com.savitar.wetalk.dao.UserRepository;
import com.savitar.wetalk.entity.User;
import com.savitar.wetalk.service.UserService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    private UserService userService;
    private UserRepository userRepository;
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method =handlerMethod.getMethod();

        LoginRquired methodAnnotation = method.getAnnotation(LoginRquired.class);
        if(methodAnnotation != null) {
            String token = request.getHeader("token");
            if(token == null) {
                throw new RuntimeException("无token，请重新登陆");
            }
            String userName;
            try {
                userName = JWT.decode(token).getAudience().get(0);
            } catch (JWTDecodeException e) {
                throw new RuntimeException("token无效，请重新登陆");
            }
            User user = userRepository.findByNickname(userName);
            System.out.println(user.getNickname()+"------------");
//            if (userName == null) {
//                throw new RuntimeException("用户不存在，请重新登陆");
//            }
//            try {
//                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//                try {
//                    verifier.verify(token);
//                } catch (JWTVerificationException e) {
//                    throw new RuntimeException("token无效，请重新登陆");
//                }
//            } catch (UnsupportedEncodingException ignore){}
//            request.setAttribute("currentUser", user);
            return true;
        }
        return true;
    }
}
