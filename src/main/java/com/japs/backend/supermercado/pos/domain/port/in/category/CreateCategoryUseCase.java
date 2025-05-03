package com.japs.backend.supermercado.pos.domain.port.in.category;

import com.japs.backend.supermercado.pos.domain.model.Category;

public interface CreateCategoryUseCase {

    Category createCategory(Category category);
}
