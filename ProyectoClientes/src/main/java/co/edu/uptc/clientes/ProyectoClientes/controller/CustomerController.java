package co.edu.uptc.clientes.ProyectoClientes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.clientes.ProyectoClientes.model.Customer;

@RequestMapping("/customers")
@RestController
public class CustomerController {
	private List<Customer> customers;
	
	public CustomerController() {
		this.customers = new ArrayList<>();
		this.customers.add(new Customer("1", "User1", "Usuario", "1234"));
		this.customers.add(new Customer("2", "User2", "Usuario auxuliar", "12345"));
	}
	
	@GetMapping("/customer")
	public List<Customer> getCustomer(){
		return this.customers;
	}
	
	@GetMapping("/customer/{username}")
	public Customer getCustomer(@PathVariable String username) {
		for(Customer cliente: this.customers) {
			if(cliente.getUsername().equals(username)) {
				return cliente;
			}
		}
		return null;
	}
	
	@PostMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer createCustomer(@RequestBody Customer cliente) {
		this.customers.add(cliente);
		return cliente;
	}
	
	@PutMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer newCustomer) {
		for(Customer customer: this.customers) {
			if(customer.getId().equals(newCustomer.getId())) {
				customer.setName(newCustomer.getName());
				customer.setPassword(newCustomer.getPassword());
				customer.setUsername(newCustomer.getUsername());
				return customer;
			}
		}
		return null;
	}
	
}
