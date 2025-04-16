package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.repository;

import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Long> {

    Optional<CategoryEntity> findByName(String name);
}
