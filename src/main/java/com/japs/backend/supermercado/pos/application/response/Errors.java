package com.japs.backend.supermercado.pos.application.response;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class Errors {
	
	private String field;
	
	private String errorMessage;

}
