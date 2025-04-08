package com.japs.backend.supermercado.pos.domain.port.in;

import com.japs.backend.supermercado.pos.domain.model.Customer;

public interface UpdateCustomerUseCase {

	Customer updateCustomer(Long id, Customer customer);
}
