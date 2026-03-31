package co.edu.uptc.josecharris.springboot.products.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.josecharris.springboot.products.domain.Product;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	
	private List<Product> listProducts;
	
	public ProductServiceImpl() {
		this.listProducts = new ArrayList<>(Arrays.asList(
				new Product(1, "Laptop", 799.9, 10),
				new Product(2, "Smartphone", 499.9, 25),
				new Product(3, "Tablet", 299.9, 15),
				new Product(4, "Smartwatch", 199.9, 30)));
	}
	
	@Override
	public List<Product> getListProducts(){
		return this.listProducts;
	}
}
