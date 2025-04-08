package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 15)
    private String document;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String mobileNumber;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String address;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;

    @Column(name = "client_type",nullable = true)
    private String clientType;

}
