package com.japs.backend.supermercado.pos.infrastructure.entry_points.restconsumer.handler;


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
	public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer customerRequest){
		try {
			return ResponseEntity.ok(createCustomerUseCase.createCustomer(customerRequest));
		} catch (RuntimeException e) {
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			log.error("Error inesperado: "+e.getMessage());
			return ResponseEntity.internalServerError().body("No se pudo crear el cliente.");
		}
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Long id,@RequestBody Customer customerRequest){
		try {
			return ResponseEntity.ok(updateCustomerUseCase.updateCustomer(id,customerRequest));
		} catch (RuntimeException e) {
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			log.error("Error inesperado: "+e.getMessage());
			return ResponseEntity.internalServerError().body("No se pudo actualizar el cliente.");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
		try {
			deleteCustomerUseCase.deleteCustomer(id);
			return ResponseEntity.ok("Se Elimino el cliente correctamente.");
		} catch (RuntimeException e) {
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			log.error("Error inesperado: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Ocurrio un inconveniente no se pudo eliminar el cliente.");
		}
	}
	
	@GetMapping("/find-by-id/{id}")
	public ResponseEntity<?> findCustomerById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(retrieveCustomerUseCase.getById(id));
		} catch (RuntimeException e) {
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			log.error("Error inesperado: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Ocurrio un inconveniente no se pudo encontrar el cliente.");
		}
	}
	
	@GetMapping("/find-by-document/{document}")
	public ResponseEntity<?> findCustomerByDocument(@PathVariable String document){
		try {
			return ResponseEntity.ok(retrieveCustomerUseCase.getByDocument(document));
		} catch (RuntimeException e) {
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			log.error("Error inesperado: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Ocurrio un inconveniente no se pudo encontrar el cliente.");
		}
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<?> findAllCustomers(){
		try {
			return ResponseEntity.ok(retrieveCustomerUseCase.getAll());
		} catch (RuntimeException e) {
			log.warn(e.getMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}catch (Exception e) {
			log.error("Error inesperado: "+e.getMessage());
			return ResponseEntity.internalServerError().body("Ocurrio un inconveniente al buscar el listado de clientes.");
		}
	}
}
