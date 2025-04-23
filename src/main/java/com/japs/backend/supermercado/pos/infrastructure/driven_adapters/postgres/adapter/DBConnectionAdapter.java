package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.adapter;

import com.japs.backend.supermercado.pos.domain.port.out.DBConnectionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DBConnectionAdapter implements DBConnectionPort {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void verifyDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
        } catch (DataAccessResourceFailureException ex) {
            throw new RuntimeException("El servicio de base de datos no está disponible. Por favor, intente más tarde.", ex);
        }
    }
}
