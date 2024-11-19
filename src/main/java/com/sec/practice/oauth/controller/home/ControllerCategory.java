package com.sec.practice.oauth.controller.home;

import com.sec.practice.oauth.persistence.entities.Category;
import com.sec.practice.oauth.service.interfaces.IServiceInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class ControllerCategory {

    @Autowired
    @Qualifier("serviceCategory")
    private IServiceInventory<Category> serviceCategory;

    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable){
        return ResponseEntity.ok(serviceCategory.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok(serviceCategory.findById(id));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Category> delete(@PathVariable Long id){
        return ResponseEntity.ok(serviceCategory.remove(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody Category category){
        return ResponseEntity.ok(serviceCategory.update(category));
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return ResponseEntity.ok(serviceCategory.save(category));
    }

}
