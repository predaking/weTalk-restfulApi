package com.savitar.wetalk.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.savitar.wetalk.annotation.LoginRequired;
import com.savitar.wetalk.dao.UserRepository;
import com.savitar.wetalk.entity.User;
import com.savitar.wetalk.service.UserService;
import com.savitar.wetalk.util.RetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "token");
        if(!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method =handlerMethod.getMethod();

        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        if(methodAnnotation != null) {
            String token = request.getHeader("token");
            System.out.println("--"+ token + "--");
            if(token == "") {
                System.out.println("-- !!!!!! --");
                response.sendError(HttpServletResponse.SC_FORBIDDEN,"无token,请重新登录");
                return false;
            }
            String userName;
            try {
                userName = JWT.decode(token).getAudience().get(0);
            } catch (JWTDecodeException e) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "token无效，请重新登录");
                return false;
            }
            User user = userRepository.findByNickname(userName);
            System.out.println(user);
            if (user == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "用户不存在，请重新登录");
                return false;
            }
            try {
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    verifier.verify(token);
                } catch (JWTVerificationException e) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "token无效，请重新登录");
                    return false;
                }
            } catch (UnsupportedEncodingException ignore){}
            request.setAttribute("currentUser", user);
            return true;
        }
        return true;
    }
}
