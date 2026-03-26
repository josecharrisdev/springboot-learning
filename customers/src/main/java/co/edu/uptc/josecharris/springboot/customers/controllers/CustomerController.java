package co.edu.uptc.josecharris.springboot.customers.controllers;


import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.josecharris.springboot.customers.model.Customer;
import co.edu.uptc.josecharris.springboot.customers.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<?> getCustomers(){
		return ResponseEntity.ok(customerService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerByID(@PathVariable int id) {
	    return ResponseEntity.ok(customerService.findByIdOrThrow(id));
	}
	
	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody Customer customer){
		Customer customerCreated = customerService.create(customer);
		return ResponseEntity.created(URI.create("/customer/"+customerCreated.getID()))
				.body(customerCreated);
		
	}
	
	@PutMapping
	public ResponseEntity<Customer> update(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.updateOrThrow(customer));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		customerService.deleteOrThrow(id);
		return ResponseEntity.noContent().build();
	}
}
