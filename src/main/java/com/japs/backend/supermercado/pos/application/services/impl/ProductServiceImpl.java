package com.japs.backend.supermercado.pos.application.services.impl;

import com.japs.backend.supermercado.pos.application.services.ProductService;
import com.japs.backend.supermercado.pos.domain.model.Product;
import com.japs.backend.supermercado.pos.domain.port.in.CreateCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.DeleteCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.RetrieveCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.UpdateCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.product.CreateProductUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.product.DeleteProductUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.product.RetrieveProductUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.product.UpdateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final CreateProductUseCase createProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;

    @Override
    public Product save(Product product) {
        return createProductUseCase.createProduct(product);
    }

    @Override
    public Product update(Long id, Product product) {
        return updateProductUseCase.updateProduct(id,product);
    }

    @Override
    public void delete(Long id) {
        deleteProductUseCase.deleteProduct(id);
    }

    @Override
    public List<Product> findAll() {
        return retrieveProductUseCase.getAll();
    }

    @Override
    public Product findById(Long id) {
        return retrieveProductUseCase.getById(id);
    }

    @Override
    public Product findByCode(String code) {
        return retrieveProductUseCase.getByCode(code);
    }
}
