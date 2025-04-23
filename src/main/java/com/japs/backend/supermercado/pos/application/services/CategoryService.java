package com.japs.backend.supermercado.pos.application.services;

import com.japs.backend.supermercado.pos.domain.model.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    Category update(Long id, Category category);

    void delete(Long id);

    List<Category> findAll();

    Category findById(Long id);

    Category findByName(String name);

}
