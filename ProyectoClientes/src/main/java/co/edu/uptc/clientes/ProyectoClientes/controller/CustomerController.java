package co.edu.uptc.clientes.ProyectoClientes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	private List<Customer> listCustomers;
	
	public CustomerController() {
		this.listCustomers = new ArrayList<>();
		this.listCustomers.add(new Customer("1", "User1", "Usuario", "1234"));
		this.listCustomers.add(new Customer("2", "User2", "Usuario auxuliar", "12345"));
	}
	
	@GetMapping("/customer")
	public List<Customer> getCustomer(){
		return this.listCustomers;
	}
	
	@GetMapping("/customer/{username}")
	public Customer getCustomer(@PathVariable String username) {
		for(Customer customer: this.listCustomers) {
			if(customer.getUsername().equals(username)) {
				return customer;
			}
		}
		return null;
	}
	
	@PostMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer createCustomer(@RequestBody Customer cliente) {
		this.listCustomers.add(cliente);
		return cliente;
	}
	
	@PutMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestBody Customer newCustomer) {
		for(Customer customer: this.listCustomers) {
			if(customer.getId().equals(newCustomer.getId())) {
				customer.setName(newCustomer.getName());
				customer.setPassword(newCustomer.getPassword());
				customer.setUsername(newCustomer.getUsername());
				return customer;
			}
		}
		return null;
	}
	
	@DeleteMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer deleteCustomer(@PathVariable String id) {
		for(Customer c: this.listCustomers) {
			if(c.getId().equals(id)) {
				this.listCustomers.remove(c);
				return c;
			}
		}
		return null;
	}
	
}
