package com.japs.backend.supermercado.pos.application.usecases.product;

import com.japs.backend.supermercado.pos.domain.model.Product;
import com.japs.backend.supermercado.pos.domain.port.in.product.RetrieveProductUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import com.japs.backend.supermercado.pos.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Component
public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public Product getById(Long id) {
        log.info("entro en caso de uso");
        if (id == null) {
            throw new IllegalArgumentException("El ID del producto no puede ser null.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un número positivo.");
        }

        dbConnectionPort.verifyDatabaseConnection();

        return productRepositoryPort.findById(id).orElseThrow(()->new NoSuchElementException("No se encontro ningun producto con el id: "+id));
    }

    @Override
    public Product getByCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Búsqueda fallida: valor de codigo es null");
        }

        dbConnectionPort.verifyDatabaseConnection();

        return productRepositoryPort.findByCode(code).orElseThrow(()->new NoSuchElementException("No se encontro ningun producto con el codigo: "+code));
    }

    @Override
    public List<Product> getAll() {
        dbConnectionPort.verifyDatabaseConnection();
        return productRepositoryPort.findAll();
    }
}
