package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper;

import com.japs.backend.supermercado.pos.domain.model.Category;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CategoryEntity;

public class CategoryMapper {

    public static Category toModel(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }

        return Category.builder()
                .id(entity.getId()!=null?entity.getId():null)
                .name(entity.getName())
                .build();
    }

    public static CategoryEntity toEntity(Category model) {
        if (model == null) {
            return null;
        }
        return CategoryEntity.builder()
                .id(model.getId()!=null?model.getId():null)
                .name(model.getName())
                .build();
    }
	
}
