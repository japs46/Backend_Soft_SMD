package com.japs.backend.supermercado.pos.domain.port.out;

import com.japs.backend.supermercado.pos.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

    Product save(Product product);

    Product update(Product product);

    void delete(Long id);

    Optional<Product> findById(Long id);

    Optional<Product> findByCode(String code);

    List<Product> findAll();
}
