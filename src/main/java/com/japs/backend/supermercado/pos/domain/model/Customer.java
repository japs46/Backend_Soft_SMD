package com.japs.backend.supermercado.pos.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Customer {

	@Schema(hidden = true)
	private Long id;

	@NotEmpty(message = "La cédula no puede ser vacio.")
	@Pattern(regexp = "\\d+", message = "La cédula solo debe contener números.")
	@Size(min = 6, max = 11, message = "La cédula debe tener entre 6 y 11 digitos.")
	private String document;

	@NotEmpty(message = "El nombre no puede ser vacio.")
	private String name;

	@Pattern(regexp = "^(\\+\\d{1,2}|\\d{1,2})\\s?\\d+$", message = "El telefono debe ser numérico, estructura que debe tener: (indicativo pais opcional +57) +(espacio opcional)+ (numero celular 3219876543) = +57 3219876543, tambien puede quedar +573219876543 o 3219876543.")
	@Size(min = 10, max = 14, message = "El numero de telefono debe contener entre 10 y 14 digitos")
	private String mobileNumber;

	@Email(message = "Debe ser un correo electrónico válido.")
	private String email;

	private String address;

	@Schema(hidden = true)
	private Date registrationDate;

	private LocalDate birthDate;

	private String clientType;

}
