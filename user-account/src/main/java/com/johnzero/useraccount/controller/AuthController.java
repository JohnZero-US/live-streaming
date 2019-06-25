package com.johnzero.useraccount.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.johnzero.model.useraccount.User;
import com.johnzero.useraccount.service.impl.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Email;
import java.util.Date;

/**
 * 描述:
 */
/*
  Created by IntelliJ IDEA.
  Type: Class
  User: John Zero
  DateTime: 2019/6/25 5:25
  Description: 
*/
@RestController("api/auth")
@Slf4j
@Validated
public class AuthController {

    @Autowired
    private AuthService authService;

    //JWT有效时间
    @Value("${jwt.valid-time}")
    private String validTime;

    /**
     * JWT密钥
     */
    @Value("${jwt.secret}")
    private String secret;

    /**
     * 通过邮箱
     *
     * @param email
     * @param password
     * @return
     */
    @PostMapping()
    public ResponseEntity<?> post(@RequestParam(required = false) @Email(message = "Please include a valid email.") String email,
                                  @RequestParam(required = false) String username,
                                  @RequestParam String password) {
        //如果邮箱和用户名都为空
        if (email == null && username == null) {
            return new ResponseEntity("Must contain username or email.", HttpStatus.BAD_REQUEST);
        }
        //
        try {
            User user = authService.getUserByEmail(email, password);
            //
            if (user == null) {
                return new ResponseEntity("Invalid Credentials.", HttpStatus.UNAUTHORIZED);
            }
            //生成JWT
            Algorithm algorithm = Algorithm.HMAC256(secret);
            long now = new Date().getTime();
            long validMillisecond = 1000 * 60 * Integer.valueOf(validTime);
            String token = JWT.create()
                    .withClaim("userId", user.getId())
                    .withExpiresAt(new Date(now + validMillisecond))
                    .sign(algorithm);
            //
            return new ResponseEntity(token, HttpStatus.OK);
        } catch (ConstraintViolationException e) {
            log.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * JWT测试
     *
     * @param token
     * @return
     */
    @PutMapping
    public ResponseEntity<?> put(@RequestParam String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (JWTVerificationException exception) {
            //Invalid signature/claims
            log.error(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
