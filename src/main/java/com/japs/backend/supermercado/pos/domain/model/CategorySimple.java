package com.japs.backend.supermercado.pos.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class CategorySimple {

    private Long id;

    @Schema(hidden = true)
    private String name;
}
