package com.japs.backend.supermercado.pos.application.usecases.category;

import com.japs.backend.supermercado.pos.domain.model.Category;
import com.japs.backend.supermercado.pos.domain.port.in.category.UpdateCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CategoryRepositoryPort;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public Category updateCategory(Long id, Category category) {
        dbConnectionPort.verifyDatabaseConnection();

        Category categoryBd = categoryRepositoryPort.findById(id).orElse(null);
        if (categoryBd == null) {
            throw new RuntimeException("No existe la categoria");
        }

        Category existingCategory = categoryRepositoryPort.findByName(category.getName()).orElse(null);
        if (existingCategory != null && existingCategory.getId() != existingCategory.getId()) {
            throw new RuntimeException("Ya existe un Cliente con la document: "+category.getName());
        }

        Category categoryBdUpdate = categoryBd.toBuilder().name(category.getName()).build();

        return categoryRepositoryPort.update(categoryBdUpdate);
    }

}
