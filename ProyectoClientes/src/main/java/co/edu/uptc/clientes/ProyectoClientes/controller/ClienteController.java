package co.edu.uptc.clientes.ProyectoClientes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.clientes.ProyectoClientes.model.Cliente;

@RequestMapping("/clientes")
@RestController
public class ClienteController {
	private List<Cliente> clientes;
	
	public ClienteController() {
		this.clientes = new ArrayList<>();
		this.clientes.add(new Cliente("User1", "Usuario", "1234"));
		this.clientes.add(new Cliente("User2", "Usuario auxuliar", "12345"));
	}
	
	@GetMapping("/cliente")
	public List<Cliente> obtenerClientes(){
		return this.clientes;
	}
	
	@GetMapping("/cliente/{username}")
	public Cliente obtenerCliente(@PathVariable("username") String username) {
		for(Cliente cliente: this.clientes) {
			if(cliente.getUsername().equals(username)) {
				return cliente;
			}
		}
		return null;
	}
	
}
