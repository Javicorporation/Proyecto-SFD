package com.example.MicroservicioProducto.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "El nombre no puede ser vacio")
    @NotNull(message = "El nombre no puede ser nulo")
    @Column(name="nombre", nullable = false)
    private String name;


    @NotBlank(message = "El fabricante no nuede ser vacio")
    @NotNull(message = "El fabricante no puede ser nulo")
    @Column(name="fabricante", nullable = false)
    private String maker;



    @NotNull(message = "el precio no puede ser nulo")
    @Column(name="precio", nullable = false)
    private double price;


    
    @NotBlank(message = "El provedor no nuede ser vacio")
    @NotNull(message = "El provedor no puede ser nulo")
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
