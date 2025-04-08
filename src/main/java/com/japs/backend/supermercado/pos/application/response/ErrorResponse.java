package com.japs.backend.supermercado.pos.application.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
public class ErrorResponse {

	private String message;
	private List<Errors> errors;

}
