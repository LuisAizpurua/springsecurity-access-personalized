package com.sec.practice.oauth.controller.home;

import com.sec.practice.oauth.persistence.repository.entities.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ControllerProd {

    @Autowired
    private RepositoryProduct repositoryProduct;


}
