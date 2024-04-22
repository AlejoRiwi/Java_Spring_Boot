package com.riwi.products.services;

import com.riwi.products.entities.Product;
import com.riwi.products.repositories.ProductRepository;
import com.riwi.products.services.service_abstract.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> getAll() {

        return this.productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Product update(Long id) {
        return null;
    }

    @Override
    public List<Product> search(String name) {
        return null;
    }
}
