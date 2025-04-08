package com.japs.backend.supermercado.pos.application.usecases;


import com.japs.backend.supermercado.pos.domain.port.in.DeleteCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

	private final CustomerRepositoryPort customerRepositoryPort;
	
	@Override
	public void deleteCustomer(Long id) {
		customerRepositoryPort.verifyDatabaseConnection();
		customerRepositoryPort.delete(id);
	}

}
