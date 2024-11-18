package com.sec.practice.oauth.controller.home;

import com.sec.practice.oauth.persistence.entities.Product;
import com.sec.practice.oauth.service.interfaces.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ControllerProd {

    @Autowired
    private IServiceProduct serviceProduct;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable){
        return ResponseEntity.ok(serviceProduct.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(serviceProduct.findById(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Product> delete(@PathVariable Long id){
        return ResponseEntity.ok(serviceProduct.remove(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product){
        return ResponseEntity.ok(serviceProduct.update(product));
    }
}
