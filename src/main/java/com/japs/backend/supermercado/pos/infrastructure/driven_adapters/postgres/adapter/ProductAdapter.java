package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.adapter;

import com.japs.backend.supermercado.pos.domain.model.Product;
import com.japs.backend.supermercado.pos.domain.port.out.ProductRepositoryPort;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.ProductEntity;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper.ProductMapper;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
@Slf4j
public class ProductAdapter implements ProductRepositoryPort {

    private final ProductEntityRepository productEntityRepository;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity= ProductMapper.toEntity(product);
        return ProductMapper.toModel(productEntityRepository.save(productEntity));
    }

    @Override
    public Product update(Product product) {
        ProductEntity productEntity= ProductMapper.toEntity(product);
        return ProductMapper.toModel(productEntityRepository.save(productEntity));
    }

    @Override
    public void delete(Long id) {
        productEntityRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productEntityRepository.findById(id).
                map(ProductMapper::toModel);
    }

    @Override
    public Optional<Product> findByCode(String code) {
        return productEntityRepository.findByCode(code).
                map(ProductMapper::toModel);
    }

    @Override
    public List<Product> findAll() {
        return productEntityRepository.findAll()
                .stream()
                .map(ProductMapper::toModel)
                .toList();
    }
}
