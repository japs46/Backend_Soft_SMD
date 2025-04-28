package com.japs.backend.supermercado.pos.application.services;

import com.japs.backend.supermercado.pos.domain.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product update(Long id, Product product);

    void delete(Long id);

    List<Product> findAll();

    Product findById(Long id);

    Product findByCode(String code);
}
