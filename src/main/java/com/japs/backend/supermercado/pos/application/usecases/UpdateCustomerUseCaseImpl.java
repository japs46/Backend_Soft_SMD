package com.japs.backend.supermercado.pos.application.usecases;

import com.japs.backend.supermercado.pos.domain.model.Customer;
import com.japs.backend.supermercado.pos.domain.port.in.UpdateCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.out.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

	private final CustomerRepositoryPort customerRepositoryPort;

	@Override
	public Customer updateCustomer(Long id, Customer customer) {

		customerRepositoryPort.verifyDatabaseConnection();
		
		Customer customerBd = customerRepositoryPort.findById(id).orElse(null);
		if (customerBd == null) {
			throw new RuntimeException("No existe el cliente");
		} 
		
		Customer existingCustomer = customerRepositoryPort.findByDocument(customer.getDocument()).orElse(null);
		if (existingCustomer != null && existingCustomer.getId() != customerBd.getId()) {
			throw new RuntimeException("Ya existe un Cliente con la document: "+customer.getDocument());
		} 
		
		Customer customerBdUpdate = updateCustomerInformation(customerBd, customer);
		if (customerBdUpdate.getBirthDate() != null && customerBdUpdate.getBirthDate().isAfter(LocalDate.now().minusYears(15))) {
		    throw new IllegalArgumentException("El Cliente debe ser mayor de 15 años.");
		}
		 
		return customerRepositoryPort.update(customerBdUpdate);
	}
	
	private Customer updateCustomerInformation(Customer customerBd, Customer customerUpdate) {

		return customerBd.toBuilder()
				.document(customerUpdate.getDocument())
				.name(customerUpdate.getName())
				.mobileNumber(customerUpdate.getMobileNumber()!=null?customerUpdate.getMobileNumber():null)
				.email(customerUpdate.getEmail()!=null?customerUpdate.getEmail():null)
				.address(customerUpdate.getAddress()!=null?customerUpdate.getAddress():null)
				.registrationDate(customerUpdate.getRegistrationDate()!=null?customerUpdate.getRegistrationDate():null)
				.birthDate(customerUpdate.getBirthDate()!=null?customerUpdate.getBirthDate():null)
				.clientType(customerUpdate.getClientType()!=null?customerUpdate.getClientType():null)
				.build();

    }

}
