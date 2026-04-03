package com.josecharris.cruds.crudproducts.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity /* Define la clase como una entidad */
@Table(name = "productos") /* Mapea el nombre de la tabla BD */
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "El nombre del producto no puede estar vacío")
	@Size(max = 100)
	@Column(nullable = false, length = 100)
	private String name;
	
	@Size(max = 500)
	private String description;
	
	@NotNull(message = "El precio del producto no puede ser nulo")
	@Column(nullable = false, precision = 10, scale = 10)
	private BigDecimal precio;
	
	@Min(value = 0, message = "El stock no puede ser negativo")
	@Column(nullable = false)
	private Integer stock = 0;
	
	@Column(nullable = false)
	private Boolean activo = true;
	
	@CreationTimestamp
	@Column(name = "creado_en", updatable = false)
	private LocalDateTime creadoEn;
	
	@UpdateTimestamp
    @Column(name = "actualizado_en")
	private LocalDateTime actualizadoEn;

	public Product() {
		super();
	}

	public Product(Long id,
			@NotBlank(message = "El nombre del producto no puede estar vacío") @Size(max = 100) String name,
			@Size(max = 500) String description,
			@NotNull(message = "El precio del producto no puede ser nulo") BigDecimal precio,
			@Min(value = 0, message = "El stock no puede ser negativo") Integer stock, Boolean activo,
			LocalDateTime creadoEn, LocalDateTime actualizadoEn) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.precio = precio;
		this.stock = stock;
		this.activo = activo;
		this.creadoEn = creadoEn;
		this.actualizadoEn = actualizadoEn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public LocalDateTime getActualizadoEn() {
		return actualizadoEn;
	}

	public void setActualizadoEn(LocalDateTime actualizadoEn) {
		this.actualizadoEn = actualizadoEn;
	}
	
	
	
	
	
}
