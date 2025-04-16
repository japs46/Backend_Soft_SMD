package com.japs.backend.supermercado.pos.application.usecases;

import com.japs.backend.supermercado.pos.domain.port.in.DeleteCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CategoryRepositoryPort;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;
    private final DBConnectionPort dbConnectionPort;

    @Override
    public void deleteCategory(Long id) {
        dbConnectionPort.verifyDatabaseConnection();
        categoryRepositoryPort.delete(id);
    }
}
