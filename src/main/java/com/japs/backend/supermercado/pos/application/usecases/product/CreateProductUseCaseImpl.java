package com.japs.backend.supermercado.pos.application.usecases.product;

import com.japs.backend.supermercado.pos.domain.model.Product;
import com.japs.backend.supermercado.pos.domain.port.in.category.RetrieveCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.product.CreateProductUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import com.japs.backend.supermercado.pos.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final RetrieveCategoryUseCase retrieveCategoryUseCase;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public Product createProduct(Product product) {
        dbConnectionPort.verifyDatabaseConnection();

        if (product.getCategory()!=null){
            retrieveCategoryUseCase.getById(product.getCategory().getId());
        }

        Product existingProduct  = productRepositoryPort.findByCode(product.getCode()).orElse(null);

        if (existingProduct != null) {
            throw new RuntimeException("Ya existe un producto con el codigo: "+existingProduct.getCode());
        }

        return productRepositoryPort.save(product);
    }
}
