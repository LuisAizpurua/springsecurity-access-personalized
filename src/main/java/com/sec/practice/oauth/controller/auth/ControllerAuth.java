package com.sec.practice.oauth.controller.auth;

import com.sec.practice.oauth.dto.UserJwt;
import com.sec.practice.oauth.dto.UserSave;
import com.sec.practice.oauth.persistence.entities.sec.User;
import com.sec.practice.oauth.service.auth.JwtServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ControllerAuth {

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestParam String jwt){
        return null;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(UserJwt userJwt){
        return null;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(UserSave userSave){
        String jwt = new JwtServiceImpl().generateJwt(userSave);
        return ResponseEntity.ok().body(Collections.singletonMap("jwt",jwt));
    }
}
