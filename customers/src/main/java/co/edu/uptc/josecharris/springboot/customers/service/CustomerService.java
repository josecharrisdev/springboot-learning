package co.edu.uptc.josecharris.springboot.customers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.josecharris.springboot.customers.controllers.exceptions.ResourceNotFoundException;
import co.edu.uptc.josecharris.springboot.customers.model.Customer;

@Service
public class CustomerService {
	
	private int idCounter = 1;
	private List<Customer> listCustomer;
	
	public CustomerService() {
		listCustomer = new ArrayList<>();
		listCustomer.add(new Customer(1, "Jose", "jcharris", "123"));
	}
	
	public Customer create(Customer customer) {
        customer.setID(idCounter++);
        listCustomer.add(customer);
        return customer;
    }
	
	public Customer findByIdOrThrow(int id) {
	    return listCustomer.stream()
	            .filter(c -> c.getID() == id)
	            .findFirst()
	            .orElseThrow(() -> 
	                new ResourceNotFoundException("Cliente no encontrado con id: " + id)
	            );
	}
	
	
	public Customer updateOrThrow(Customer updatedCustomer) {
        Customer existing = findByIdOrThrow(updatedCustomer.getID());

        existing.setName(updatedCustomer.getName());
        existing.setUsername(updatedCustomer.getUsername());
        existing.setPassword(updatedCustomer.getPassword());

        return existing;
    }
	
	public void deleteOrThrow(int id) {
        Customer existing = findByIdOrThrow(id);
        listCustomer.remove(existing);
    }
	
	public List<Customer> findAll() {
		return listCustomer;
	}
	
}
