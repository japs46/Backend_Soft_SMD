package com.japs.backend.supermercado.pos.application.usecases;

import com.japs.backend.supermercado.pos.domain.model.Customer;
import com.japs.backend.supermercado.pos.domain.port.in.RetrieveCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CustomerRepositoryPort;
import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class RetrieveCustomerUseCaseImpl implements RetrieveCustomerUseCase {

	private final CustomerRepositoryPort customerRepositoryPort;
	private final DBConnectionPort dbConnectionPort;

	@Override
	public Customer getById(Long id) {
		
		if (id == null) {
			throw new IllegalArgumentException("El ID del cliente no puede ser nulo.");
		}
		
		if (id <= 0) {
	        throw new IllegalArgumentException("El ID del cliente debe ser un número positivo.");
	    }

		dbConnectionPort.verifyDatabaseConnection();
		
		return customerRepositoryPort.findById(id).orElseThrow(()->new NoSuchElementException("No se encontro ningun cliente: "+id));
	}

	@Override
	public Customer getByDocument(String document) {
		
		if (document == null) {
			throw new IllegalArgumentException("Búsqueda fallida: valor de cédula es null");
		}

		dbConnectionPort.verifyDatabaseConnection();
		
		return customerRepositoryPort.findByDocument(document).orElseThrow(()->new NoSuchElementException("No se encontro ningun cliente con la document: "+document));
	}

	@Override
	public List<Customer> getAll() {
		dbConnectionPort.verifyDatabaseConnection();
		return customerRepositoryPort.findAll();
	}

}
