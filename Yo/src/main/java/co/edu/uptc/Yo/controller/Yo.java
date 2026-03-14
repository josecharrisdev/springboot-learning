package co.edu.uptc.Yo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/YoController")
@RestController
@CrossOrigin("*")
public class Yo {
	
	@GetMapping(path = "/obtenerNumeros", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Integer> getNumbers() {
		return Arrays.asList(1, 2 , 3, 4, 5);
	}
	
}
