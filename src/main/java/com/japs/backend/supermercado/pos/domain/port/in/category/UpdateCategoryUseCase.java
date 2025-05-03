package com.japs.backend.supermercado.pos.domain.port.in.category;

import com.japs.backend.supermercado.pos.domain.model.Category;

public interface UpdateCategoryUseCase {

    Category updateCategory(Long id, Category category);
}
