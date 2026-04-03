package com.josecharris.cruds.crudproducts.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductRequestDTO {
	
	@NotBlank(message = "El nombre es requerido")
    @Size(max = 100)
    private String nombre;

    @Size(max = 500)
    private String descripcion;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal precio;

    @Min(0)
    private Integer stock;
    

	public ProductRequestDTO() {
		super();
	}

	public ProductRequestDTO(@NotBlank(message = "El nombre es requerido") @Size(max = 100) String nombre,
			@Size(max = 500) String descripcion, @NotNull @DecimalMin("0.01") BigDecimal precio,
			@Min(0) Integer stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
    
}
