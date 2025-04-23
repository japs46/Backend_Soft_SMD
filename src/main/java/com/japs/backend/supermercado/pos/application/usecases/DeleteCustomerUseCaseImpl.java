package com.japs.backend.supermercado.pos.application.usecases;


import com.japs.backend.supermercado.pos.domain.port.in.DeleteCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CustomerRepositoryPort;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

	private final CustomerRepositoryPort customerRepositoryPort;
	private final DBConnectionPort dbConnectionPort;
	
	@Override
	public void deleteCustomer(Long id) {
		dbConnectionPort.verifyDatabaseConnection();
		customerRepositoryPort.delete(id);
	}

}
