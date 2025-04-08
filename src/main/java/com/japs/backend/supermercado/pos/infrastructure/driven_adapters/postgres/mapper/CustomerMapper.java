package com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.mapper;

import com.japs.backend.supermercado.pos.domain.model.Customer;
import com.japs.backend.supermercado.pos.infrastructure.driven_adapters.postgres.entities.CustomerEntity;


public class CustomerMapper {

    public static Customer toModel(CustomerEntity entity) {
        if (entity == null) {
            return null;
        }

        return Customer.builder()
                .id(entity.getId()!=null?entity.getId():null)
                .document(entity.getDocument())
                .name(entity.getName())
                .mobileNumber(entity.getMobileNumber()!=null?entity.getMobileNumber():null)
                .email(entity.getEmail()!=null?entity.getEmail():null)
                .address(entity.getAddress()!=null?entity.getAddress():null)
                .registrationDate(entity.getRegistrationDate()!=null?entity.getRegistrationDate():null)
                .birthDate(entity.getBirthDate()!=null?entity.getBirthDate():null)
                .clientType(entity.getClientType()!=null?entity.getClientType():null)
                .build();
    }

    public static CustomerEntity toEntity(Customer model) {
        if (model == null) {
            return null;
        }
        return CustomerEntity.builder()
                .id(model.getId()!=null?model.getId():null)
                .document(model.getDocument())
                .name(model.getName())
                .mobileNumber(model.getMobileNumber()!=null?model.getMobileNumber():null)
                .email(model.getEmail()!=null?model.getEmail():null)
                .address(model.getAddress()!=null?model.getAddress():null)
                .registrationDate(model.getRegistrationDate()!=null?model.getRegistrationDate():null)
                .birthDate(model.getBirthDate()!=null?model.getBirthDate():null)
                .clientType(model.getClientType()!=null?model.getClientType():null)
                .build();
    }
	
}
