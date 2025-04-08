package com.japs.backend.supermercado.pos.domain.port.in;

import com.japs.backend.supermercado.pos.domain.model.Customer;

import java.util.List;

public interface RetrieveCustomerUseCase {

	Customer getById(Long id);

	Customer getByDocument(String document);

	List<Customer> getAll();
}
