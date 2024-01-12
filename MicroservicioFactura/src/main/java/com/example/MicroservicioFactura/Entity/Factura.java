package com.example.MicroservicioFactura.Entity;

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
@Table(name = "facturas")
@Getter
@Setter
@NoArgsConstructor

public class Factura {

    

    public Factura(Long id, Date fechaExp, String type, String storeName, String sellerName) {
        super();
        this.id = id;
        this.fechaExp = fechaExp;
        this.type = type;
        this.storeName = storeName;
        this.sellerName = sellerName;
    }

    public Factura(Date fechaExp, String type, String storeName, String sellerName) {
        super();
        this.fechaExp = fechaExp;
        this.type = type;
        this.storeName = storeName;
        this.sellerName = sellerName;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name = "Fecha de expedicion", nullable = false)
    private Date fechaExp;

    @NotBlank(message = "El tipo de factura no puede ser vacio")
    @NotNull(message = "El tipo de factura no puede ser nulo ")
    @Column(name = "tipo", nullable = false)
    private String type;

    @NotBlank(message = "El nombre de la tienda no puede ser vacio")
    @NotNull(message = "El nombre de la tienda de factura no puede ser nulo ")
    @Column(name = "nombre de tienda", nullable = false)
    private String storeName;

    @NotBlank(message = "El dato vendedor de factura no puede ser vacio")
    @NotNull(message = "El dato vendedor de factura no puede ser nulo ")
    @Column(name = "vendedor", nullable = false)
    private String sellerName;


    @Override
    public String toString() {
        return "Factura [id=" + id + ", fechaExp=" + fechaExp + ", type=" + type + ", storeName=" + storeName
                + ", sellerName=" + sellerName + "]";
    }   



}
