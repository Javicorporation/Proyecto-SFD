package com.example.MicroservicioProducto.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor

public class Producto {


    public Producto(long id, String name, String maker, double price, String supplier, Date fechaExp) {
        super();
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.supplier = supplier;
        this.fechaExp = fechaExp;
    }
    public Producto(String name, String maker, double price, String supplier, Date fechaExp) {
        super();
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.supplier = supplier;
        this.fechaExp = fechaExp;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="nombre", nullable = false)
    private String name;
    @Column(name="fabricante", nullable = false)
    private String maker;
    @Column(name="precio", nullable = false)
    private double price;
    @Column(name="proveedor", nullable = false)
    private String supplier;
    @Column(name="fechaExpiracion", nullable = false)
    private Date fechaExp;


    @Override
    public String toString() {
        return "Producto [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + ", supplier="
                + supplier + ", fechaExp=" + fechaExp + "]";
    }
}
