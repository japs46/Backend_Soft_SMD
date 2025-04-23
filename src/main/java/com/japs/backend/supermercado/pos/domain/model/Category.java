package com.japs.backend.supermercado.pos.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Category {

    private Long id;

    private String name;
}
