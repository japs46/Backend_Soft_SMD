package com.japs.backend.supermercado.pos.domain.port.in.category;

import com.japs.backend.supermercado.pos.domain.model.Category;

import java.util.List;

public interface RetrieveCategoryUseCase {

    Category getById(Long id);

    Category getByName(String name);

    List<Category> getAll();
}
