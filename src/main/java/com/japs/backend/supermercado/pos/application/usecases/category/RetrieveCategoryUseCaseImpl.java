package com.japs.backend.supermercado.pos.application.usecases.category;

import com.japs.backend.supermercado.pos.domain.model.Category;
import com.japs.backend.supermercado.pos.domain.port.in.category.RetrieveCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CategoryRepositoryPort;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class RetrieveCategoryUseCaseImpl implements RetrieveCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public Category getById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("El ID de la categoria no puede ser nulo.");
        }

        if (id <= 0) {
            throw new IllegalArgumentException("El ID de la categoria debe ser un número positivo.");
        }

        dbConnectionPort.verifyDatabaseConnection();

        return categoryRepositoryPort.findById(id).orElseThrow(()->new NoSuchElementException("No se encontro ninguna categoria con id: "+id));
    }

    @Override
    public Category getByName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Búsqueda fallida: El nombre no puede ser null");
        }

        dbConnectionPort.verifyDatabaseConnection();

        return categoryRepositoryPort.findByName(name).orElseThrow(()->new NoSuchElementException("No se encontro ninguna categoria con el nombre: "+name));
    }

    @Override
    public List<Category> getAll() {
        dbConnectionPort.verifyDatabaseConnection();
        return categoryRepositoryPort.findAll();
    }
}
