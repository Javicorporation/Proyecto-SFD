package com.example.MicroservicioProducto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MicroservicioProducto.Entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
