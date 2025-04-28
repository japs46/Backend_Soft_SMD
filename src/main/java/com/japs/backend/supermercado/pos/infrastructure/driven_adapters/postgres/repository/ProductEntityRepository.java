package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.repository;

import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity,Long> {

    Optional<ProductEntity> findByCode(String code);

}
