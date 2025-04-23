package com.japs.backend.supermercado.pos.application.usecases;

import com.japs.backend.supermercado.pos.domain.model.Customer;
import com.japs.backend.supermercado.pos.domain.port.in.CreateCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CustomerRepositoryPort;

import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

	private final CustomerRepositoryPort customerRepositoryPort;
	private final DBConnectionPort dbConnectionPort;

	@Override
	public Customer createCustomer(Customer customer) {

		dbConnectionPort.verifyDatabaseConnection();

		Customer existingCustomer  = customerRepositoryPort.findByDocument(customer.getDocument()).orElse(null);

		if (existingCustomer != null) {
			throw new RuntimeException("Ya existe un Cliente con la cedula: "+customer.getDocument());
		}

		if (customer.getBirthDate() != null && customer.getBirthDate().isAfter(LocalDate.now().minusYears(15))) {
			throw new IllegalArgumentException("El Cliente debe ser mayor de 15 años.");
		}

		return customerRepositoryPort.save(customer);
	}


}
