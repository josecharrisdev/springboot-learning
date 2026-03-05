package com.curso.ia.spring.EjercicioProductos;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductController {
    private List<Product> listProduct;

    public ProductController(){
        this.listProduct = new ArrayList<>();
        listProduct.add(new Product("001", "Product 1"));
    }

    @GetMapping("/productos")
    public List<Product> consultarProductos() {
        return this.listProduct;
    }
    
    
    @GetMapping("/productoPorCodigo")
    public Product consultarProductos(@RequestParam String codeProduct) {
        return this.findProductByCode(codeProduct);
    }

    public Product findProductByCode(String codeProduct){
        for(Product product: this.listProduct){
            if(product.getCode().equals(codeProduct)){
                return product;
            }
        }
        return null;
    }

    @PostMapping("/productos")
    public Product agregarProducto(@RequestBody Product product) {
        this.listProduct.add(product);
        return product;
    }
    
    
}
