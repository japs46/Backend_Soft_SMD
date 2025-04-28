package com.japs.backend.supermercado.pos.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class ProductSimple {

    private Long id;

    private String code;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stockQuantity;

    private String unitMeasurement;

    private String accessCode;

    private LocalDate createdAt;

    private LocalDate updateAt;
}
