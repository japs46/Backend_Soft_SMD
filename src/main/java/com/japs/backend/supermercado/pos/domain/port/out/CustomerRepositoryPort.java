package com.japs.backend.supermercado.pos.domain.port.out;

import com.japs.backend.supermercado.pos.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepositoryPort {

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete(Long id);

    Optional<Customer> findById(Long id);

    Optional<Customer> findByDocument(String document);

    List<Customer> findAll();

}
