package com.japs.backend.supermercado.pos.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Category {

    @Schema(hidden = true)
    private Long id;

    @NotEmpty(message = "El nombre no puede ser vacio.")
    @Size(max = 30, message = "El nombre supera la cantidad de caracteres permitida [max. 30 caracteres]")
    private String name;

    @Schema(hidden = true)
    private List<ProductSimple> products;
}
