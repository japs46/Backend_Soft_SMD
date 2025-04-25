package com.japs.backend.supermercado.pos.infrastructure.entry_points.restconsumer.handler;


import com.japs.backend.supermercado.pos.application.response.ApiResponse;
import com.japs.backend.supermercado.pos.application.utils.ResponseBuilder;
import com.japs.backend.supermercado.pos.domain.model.Customer;
import com.japs.backend.supermercado.pos.domain.port.in.CreateCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.DeleteCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.RetrieveCustomerUseCase;
import com.japs.backend.supermercado.pos.domain.port.in.UpdateCustomerUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
@Slf4j
public class CustomerController {

	private final CreateCustomerUseCase createCustomerUseCase;
	private final UpdateCustomerUseCase updateCustomerUseCase;
	private final DeleteCustomerUseCase deleteCustomerUseCase;
	private final RetrieveCustomerUseCase retrieveCustomerUseCase;

	@PostMapping("/save")
	public ResponseEntity<ApiResponse<Customer>> saveCustomer(@Valid @RequestBody Customer customerRequest){
		log.info("Inicio creación de cliente");
		log.info("request create cliente: {}",customerRequest.toString());

		Customer customer = createCustomerUseCase.createCustomer(customerRequest);
		ApiResponse<Customer> apiResponse = ResponseBuilder.successMessage("Cliente creado exitosamente",customer);

		log.info("response create cliente: {}",apiResponse.toString());
		log.info("Finalizo creación de cliente");

		return ResponseEntity.ok(apiResponse);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse<Customer>> updateCustomer(@PathVariable Long id,@RequestBody Customer customerRequest){
		log.info("Inicio actualizacion de cliente: {}",id);
		log.info("request update cliente: {}",customerRequest.toString());

		Customer customer = updateCustomerUseCase.updateCustomer(id,customerRequest);
		ApiResponse<Customer> apiResponse = ResponseBuilder.successMessage("Cliente actualizado exitosamente",customer);

		log.info("response update cliente: {}",apiResponse.toString());
		log.info("Finalizo actualizacion de cliente");

		return ResponseEntity.ok(apiResponse);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteCustomer(@PathVariable Long id){
		log.info("Inicio eliminacion cliente");
		log.info("request entrada id: {}",id);

		deleteCustomerUseCase.deleteCustomer(id);
		ApiResponse<Void> apiResponse = ResponseBuilder.successMessage("Se Elimino el cliente correctamente.");

		log.info("response eliminar cliente: {}",apiResponse.toString());
		log.info("Finalizo eliminacion de cliente");

		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable Long id){
		return ResponseEntity.ok(retrieveCustomerUseCase.getById(id));
	}
	
	@GetMapping("/find-by-document/{document}")
	public ResponseEntity<Customer> findCustomerByDocument(@PathVariable String document){
		return ResponseEntity.ok(retrieveCustomerUseCase.getByDocument(document));
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<ApiResponse<List<Customer>>> findAllCustomers(){
		log.info("Inicio busqueda de todos los clientes");
		List<Customer> listCustomers = retrieveCustomerUseCase.getAll();

		ApiResponse<List<Customer>> apiResponse = ResponseBuilder.successMessage("Clientes encontrados exitosamente: "+
				listCustomers.size(),listCustomers);

		log.info("response busqueda cliente: {}",apiResponse.toString());
		log.info("Finalizo busqueda de todos los clientes");

		return ResponseEntity.ok(apiResponse);
	}
}
