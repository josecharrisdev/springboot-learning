package co.edu.uptc.josecharris.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.josecharris.springboot.products.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productServiceImpl;
	
	@GetMapping
	public ResponseEntity<?> findAllProducts(){
		return ResponseEntity.ok(this.productServiceImpl.getListProducts());
	}
}
