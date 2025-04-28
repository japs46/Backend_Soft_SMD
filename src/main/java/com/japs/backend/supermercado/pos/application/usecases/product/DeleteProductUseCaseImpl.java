package com.japs.backend.supermercado.pos.application.usecases.product;

import com.japs.backend.supermercado.pos.domain.port.in.product.DeleteProductUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import com.japs.backend.supermercado.pos.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public void deleteProduct(Long id) {
        dbConnectionPort.verifyDatabaseConnection();
        productRepositoryPort.delete(id);
    }
}
