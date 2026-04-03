package com.josecharris.cruds.crudproducts.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.josecharris.cruds.crudproducts.dto.ProductRequestDTO;
import com.josecharris.cruds.crudproducts.dto.ProductoResponseDTO;
import com.josecharris.cruds.crudproducts.exception.ResourceNotFoundException;
import com.josecharris.cruds.crudproducts.model.Product;
import com.josecharris.cruds.crudproducts.repository.ProductoRepository;


@Service
@Transactional(readOnly = true)
public class ProductoService {
	private final ProductoRepository productoRepository;

    // 🔹 Constructor manual (reemplaza @RequiredArgsConstructor)
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoResponseDTO> listarActivos() {
        return productoRepository.findByActivoTrue()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO obtenerPorId(Long id) {
        return toResponseDTO(buscarOFallar(id));
    }

    @Transactional
    public ProductoResponseDTO crear(ProductRequestDTO dto) {
        Product producto = new Product();
        producto.setName(dto.getNombre());
        producto.setDescription(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock() != null ? dto.getStock() : 0);
        producto.setActivo(true);
        return toResponseDTO(productoRepository.save(producto));
    }

    @Transactional
    public ProductoResponseDTO actualizar(Long id, ProductRequestDTO dto) {
        Product producto = buscarOFallar(id);
        producto.setName(dto.getNombre());
        producto.setDescription(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        return toResponseDTO(productoRepository.save(producto));
    }

    @Transactional
    public void eliminar(Long id) {
        Product producto = buscarOFallar(id);
        producto.setActivo(false); // Soft delete
        productoRepository.save(producto);
    }

    // ── Métodos privados ──────────────────────────────
    private Product buscarOFallar(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Producto no encontrado con id: " + id));
    }

    private ProductoResponseDTO toResponseDTO(Product p) {
        // 🔹 Reemplazo de builder()
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getName());
        dto.setDescripcion(p.getDescription());
        dto.setPrecio(p.getPrecio());
        dto.setStock(p.getStock());
        dto.setActivo(p.getActivo());
        dto.setCreadoEn(p.getCreadoEn());
        return dto;
    }
}
