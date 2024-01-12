package com.example.MicroservicioFactura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MicroservicioFactura.Entity.Factura;
@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
