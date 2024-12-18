package com.sec.practice.oauth.service.auth;

import com.sec.practice.oauth.dto.*;
import com.sec.practice.oauth.exceptions.*;
import com.sec.practice.oauth.persistence.entities.sec.User;
import com.sec.practice.oauth.persistence.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServiceImpl{


    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private ServiceJwtImpl serviceJwt;

    public UserJwt authenticateUser(AuthUser authUser) {
      User user = repositoryUser.findByUsername(authUser.getUsername())
              .orElseThrow(() -> new NotExistsEntity("Not exists the entity User"));

      return new UserJwt(
              user.getUsername(),
              new Date(System.currentTimeMillis()),
              serviceJwt.generateJwt(user) );
    }


}
