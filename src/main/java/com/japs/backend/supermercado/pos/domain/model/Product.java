package com.japs.backend.supermercado.pos.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CategoryEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class Product {

    @Schema(hidden = true)
    private Long id;

    @NotEmpty(message = "El codigo no puede ser vacio.")
    @Pattern(regexp = "\\d+", message = "El codigo solo debe contener números.")
    @Size(max = 20, message = "El codigo supera la cantidad de caracteres permitida [max. 20 caracteres]")
    private String code;

    @NotEmpty(message = "El nombre no puede ser vacio.")
    @Size(max = 255, message = "El nombre supera la cantidad de caracteres permitida [max. 255 caracteres]")
    private String name;

    @Size(max = 500, message = "La descripcion supera la cantidad de caracteres permitida [max. 500 caracteres]")
    private String description;

    @NotNull(message = "El precio no puede ser null.")
    @Digits(integer = 8, fraction = 2, message = "El precio debe tener máximo 8 dígitos enteros y 2 decimales")
    private BigDecimal price;

    @NotNull(message = "La cantidadStock no puede ser null")
    private Integer stockQuantity;

    @NotEmpty(message = "La unidad de medida no puede ser vacio.")
    @Size(max = 2, message = "La unidad de medida supera la cantidad de caracteres permitida [max. 2 caracteres]")
    private String unitMeasurement;

    @Size(max = 4, message = "El codigoAcceso supera la cantidad de caracteres permitida [max. 4 caracteres]")
    private String accessCode;

    private CategorySimple category;

    @Schema(hidden = true)
    private LocalDate createdAt;

    @Schema(hidden = true)
    private LocalDate updateAt;
}
