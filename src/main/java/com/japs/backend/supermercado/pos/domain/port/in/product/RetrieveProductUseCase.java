package com.japs.backend.supermercado.pos.domain.port.in.product;

import com.japs.backend.supermercado.pos.domain.model.Product;

import java.util.List;

public interface RetrieveProductUseCase {

    Product getById(Long id);

    Product getByCode(String code);

    List<Product> getAll();
}
