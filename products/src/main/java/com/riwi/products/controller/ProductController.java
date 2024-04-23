package com.riwi.products.controller;

import com.riwi.products.entities.Product;
import com.riwi.products.services.service_abstract.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private final IProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {

        return ResponseEntity.ok(this.productService.update(id, product));
    }


    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product objProduct) {
        return ResponseEntity.ok(this.productService.save(objProduct));
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
