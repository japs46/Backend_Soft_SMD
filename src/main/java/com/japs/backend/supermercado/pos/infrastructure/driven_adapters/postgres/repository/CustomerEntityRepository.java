package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.repository;

import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerEntityRepository extends JpaRepository<CustomerEntity,Long> {

    Optional<CustomerEntity> findByDocument(String document);
}
