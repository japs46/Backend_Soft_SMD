package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.adapter;

import com.japs.backend.supermercado.pos.domain.model.Category;
import com.japs.backend.supermercado.pos.domain.port.out.CategoryRepositoryPort;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CategoryEntity;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper.CategoryMapper;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.repository.CategoryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CategoryAdapter implements CategoryRepositoryPort {

    private final CategoryEntityRepository categoryEntityRepository;

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity= CategoryMapper.toEntity(category);
        return CategoryMapper.toModel(categoryEntityRepository.save(categoryEntity));
    }

    @Override
    public Category update(Category category) {
        CategoryEntity categoryEntity= CategoryMapper.toEntity(category);
        return CategoryMapper.toModel(categoryEntityRepository.save(categoryEntity));
    }

    @Override
    public void delete(Long id) {
        categoryEntityRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryEntityRepository.findAll()
                .stream()
                .map(CategoryMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryEntityRepository.findById(id).
                map(CategoryMapper::toModel);
    }

    @Override
    public Optional<Category> findByName(String name) {
        return categoryEntityRepository.findByName(name).
                map(CategoryMapper::toModel);
    }
}
