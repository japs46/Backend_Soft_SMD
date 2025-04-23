package com.japs.backend.supermercado.pos.domain.port.out;

import com.japs.backend.supermercado.pos.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {

    Category save(Category category);

    Category update(Category category);

    void delete(Long id);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    Optional<Category> findByName(String name);
}
