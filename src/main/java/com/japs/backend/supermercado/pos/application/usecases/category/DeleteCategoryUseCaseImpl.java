package com.japs.backend.supermercado.pos.application.usecases.category;

import com.japs.backend.supermercado.pos.domain.model.Category;
import com.japs.backend.supermercado.pos.domain.port.in.category.DeleteCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.category.RetrieveCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CategoryRepositoryPort;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final RetrieveCategoryUseCase retrieveCategoryUseCase;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public void deleteCategory(Long id) {
        dbConnectionPort.verifyDatabaseConnection();

        Category category = retrieveCategoryUseCase.getById(id);

        if (category == null){
            throw new RuntimeException("La categoria que esta intentando eliminar no fue encontrada, refresque el listado.");
        }

        if (!category.getProducts().isEmpty()){
            throw new RuntimeException("No es posible eliminar esta categoria, por que hay productos que estan asociados a esta categoria");
        }

        categoryRepositoryPort.delete(id);
    }
}
