package com.japs.backend.supermercado.pos.application.usecases.category;

import com.japs.backend.supermercado.pos.domain.model.Category;
import com.japs.backend.supermercado.pos.domain.port.in.category.CreateCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CategoryRepositoryPort;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public Category createCategory(Category category) {
        dbConnectionPort.verifyDatabaseConnection();

        Category existingCategory  = categoryRepositoryPort.findByName(category.getName()).orElse(null);

        if (existingCategory != null) {
            throw new RuntimeException("Ya existe una categoria con ese nombre: "+category.getName());
        }

        return categoryRepositoryPort.save(category);
    }
}
