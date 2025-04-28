package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper;

import com.japs.backend.supermercado.pos.domain.model.CategorySimple;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CategoryEntity;

public class CategorySimpleMapper {

    public static CategorySimple toSimple(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }

        return CategorySimple.builder()
                .id(entity.getId() != null ? entity.getId() : null)
                .name(entity.getName())
                .build();
    }

    public static CategoryEntity toEntity(CategorySimple simple) {
        if (simple == null) {
            return null;
        }

        return CategoryEntity.builder()
                .id(simple.getId() != null ? simple.getId() : null)
                .name(simple.getName())
                .build();
    }
}
