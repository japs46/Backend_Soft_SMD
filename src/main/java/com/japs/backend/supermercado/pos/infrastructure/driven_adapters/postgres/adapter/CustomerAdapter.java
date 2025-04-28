package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.adapter;

import com.japs.backend.supermercado.pos.domain.model.Customer;
import com.japs.backend.supermercado.pos.domain.port.out.CustomerRepositoryPort;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CustomerEntity;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper.CustomerMapper;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.repository.CustomerEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CustomerAdapter implements CustomerRepositoryPort {

    private final CustomerEntityRepository customerEntityRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity= CustomerMapper.toEntity(customer);
        return CustomerMapper.toModel(customerEntityRepository.save(customerEntity));
    }

    @Override
    public void delete(Long id) {
        customerEntityRepository.deleteById(id);
    }

    @Override
    public Customer update(Customer customer) {
        CustomerEntity customerEntity= CustomerMapper.toEntity(customer);
        return CustomerMapper.toModel(customerEntityRepository.save(customerEntity));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerEntityRepository.findById(id).
                map(CustomerMapper::toModel);
    }

    @Override
    public List<Customer> findAll() {
        return customerEntityRepository.findAll()
                .stream()
                .map(CustomerMapper::toModel)
                .toList();
    }

    @Override
    public Optional<Customer> findByDocument(String document) {
        return customerEntityRepository.findByDocument(document).
                map(CustomerMapper::toModel);
    }

}
