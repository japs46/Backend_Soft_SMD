package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper;

import com.japs.backend.supermercado.pos.domain.model.CategorySimple;
import com.japs.backend.supermercado.pos.domain.model.ProductSimple;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CategoryEntity;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.ProductEntity;

public class ProductSimpleMapper {

    public static ProductSimple toSimple(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        return ProductSimple.builder()
                .id(entity.getId()!=null?entity.getId():null)
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription()!=null?entity.getDescription():null)
                .price(entity.getPrice())
                .stockQuantity(entity.getStockQuantity())
                .unitMeasurement(entity.getUnitMeasurement())
                .accessCode(entity.getAccessCode()!=null?entity.getAccessCode():null)
                .build();
    }

    public static ProductEntity toEntity(ProductSimple simple) {
        if (simple == null) {
            return null;
        }

        return ProductEntity.builder()
                .id(simple.getId()!=null?simple.getId():null)
                .code(simple.getCode())
                .name(simple.getName())
                .description(simple.getDescription()!=null?simple.getDescription():null)
                .price(simple.getPrice())
                .stockQuantity(simple.getStockQuantity())
                .unitMeasurement(simple.getUnitMeasurement())
                .accessCode(simple.getAccessCode()!=null?simple.getAccessCode():null)
                .build();
    }
}
