package com.sec.practice.oauth.controller.auth;

import com.sec.practice.oauth.dto.AuthUser;
import com.sec.practice.oauth.dto.UserJwt;
import com.sec.practice.oauth.dto.UserSave;
import com.sec.practice.oauth.service.auth.AuthServiceImpl;
import com.sec.practice.oauth.service.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class ControllerAuth {

    @Autowired
    private AuthServiceImpl authServiceImpl;

    @Autowired
    private JwtServiceImpl jwtService;

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validate(@RequestParam(name = "jwt") String jwt){
        return  Optional.of(jwtService.extractClaims(jwt)).isPresent()
                ? ResponseEntity.ok(true)
                : ResponseEntity.badRequest().body(false);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthUser authUser){
        Optional<UserJwt> userJwt = Optional.ofNullable(authServiceImpl.authenticateUser(authUser));

        System.out.println("auth: " + userJwt.get().toString());
        return userJwt.isPresent()
                ? ResponseEntity.ok(userJwt.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message","The authenticate invalid"));
    }
}