package com.josecharris.cruds.crudproducts.repository;

import com.josecharris.cruds.crudproducts.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Product, Long> {
	List<Product> findByActivoTrue();
    boolean existsByNombreIgnoreCase(String nombre);
}
