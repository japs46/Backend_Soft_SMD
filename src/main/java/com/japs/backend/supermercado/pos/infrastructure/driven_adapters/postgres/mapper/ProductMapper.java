package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper;

import com.japs.backend.supermercado.pos.domain.model.Product;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.ProductEntity;

public class ProductMapper {

    public static Product toModel(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        return Product.builder()
                .id(entity.getId()!=null?entity.getId():null)
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription()!=null?entity.getDescription():null)
                .price(entity.getPrice())
                .stockQuantity(entity.getStockQuantity())
                .unitMeasurement(entity.getUnitMeasurement())
                .accessCode(entity.getAccessCode()!=null?entity.getAccessCode():null)
                .category(CategorySimpleMapper.toSimple(entity.getCategory()))
                .build();
    }

    public static ProductEntity toEntity(Product model) {
        if (model == null) {
            return null;
        }
        return ProductEntity.builder()
                .id(model.getId()!=null?model.getId():null)
                .code(model.getCode())
                .name(model.getName())
                .description(model.getDescription()!=null?model.getDescription():null)
                .price(model.getPrice())
                .stockQuantity(model.getStockQuantity())
                .unitMeasurement(model.getUnitMeasurement())
                .accessCode(model.getAccessCode()!=null?model.getAccessCode():null)
                .category(CategorySimpleMapper.toEntity(model.getCategory()))
                .build();
    }

}
