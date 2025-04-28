package com.japs.backend.supermercado.pos.domain.port.in.product;

import com.japs.backend.supermercado.pos.domain.model.Product;

public interface UpdateProductUseCase {

    Product updateProduct(Long id, Product product);
}
