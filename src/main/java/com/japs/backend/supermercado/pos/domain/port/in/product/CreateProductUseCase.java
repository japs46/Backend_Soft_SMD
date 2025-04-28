package com.japs.backend.supermercado.pos.domain.port.in.product;

import com.japs.backend.supermercado.pos.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);
}
