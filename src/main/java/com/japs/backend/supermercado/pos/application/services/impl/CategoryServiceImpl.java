package com.japs.backend.supermercado.pos.application.services.impl;

import com.japs.backend.supermercado.pos.application.services.CategoryService;
import com.japs.backend.supermercado.pos.domain.model.Category;
import com.japs.backend.supermercado.pos.domain.port.in.CreateCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.DeleteCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.RetrieveCategoryUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.UpdateCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final RetrieveCategoryUseCase retrieveCategoryUseCase;

    @Override
    public Category save(Category category) {
        return createCategoryUseCase.createCategory(category);
    }

    @Override
    public Category update(Long id, Category category) {
        return updateCategoryUseCase.updateCategory(id,category);
    }

    @Override
    public void delete(Long id) {
        deleteCategoryUseCase.deleteCategory(id);
    }

    @Override
    public List<Category> findAll() {
        return retrieveCategoryUseCase.getAll();
    }

    @Override
    public Category findById(Long id) {
        return retrieveCategoryUseCase.getById(id);
    }

    @Override
    public Category findByName(String name) {
        return retrieveCategoryUseCase.getByName(name);
    }
}
