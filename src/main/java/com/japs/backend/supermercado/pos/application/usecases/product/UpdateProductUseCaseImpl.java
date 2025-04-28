package com.japs.backend.supermercado.pos.application.usecases.product;

import com.japs.backend.supermercado.pos.domain.model.Product;
import com.japs.backend.supermercado.pos.domain.port.in.product.UpdateProductUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import com.japs.backend.supermercado.pos.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public Product updateProduct(Long id, Product product) {
        dbConnectionPort.verifyDatabaseConnection();

        Product ProductBd = productRepositoryPort.findById(id).orElse(null);
        if (ProductBd == null) {
            throw new RuntimeException("No existe el producto");
        }

        Product existingProduct = productRepositoryPort.findByCode(product.getCode()).orElse(null);
        if (existingProduct != null && existingProduct.getId() != id) {
            throw new RuntimeException("Ya existe un producto con el codigo: "+product.getCode());
        }

        Product productBdUpdate = buildUpdatedProduct(ProductBd, product);

        return productRepositoryPort.update(productBdUpdate);
    }

    private Product buildUpdatedProduct(Product productBd, Product productUpdate) {

        return productBd.toBuilder()
                .code(productUpdate.getCode())
                .name(productUpdate.getName())
                .description(productUpdate.getDescription()!=null?productUpdate.getDescription():null)
                .price(productUpdate.getPrice())
                .stockQuantity(productUpdate.getStockQuantity())
                .unitMeasurement(productUpdate.getUnitMeasurement())
                .accessCode(productUpdate.getAccessCode()!=null?productUpdate.getAccessCode():null)
                .category(productUpdate.getCategory())
                .build();

    }
}
