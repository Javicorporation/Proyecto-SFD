package com.example.MicroservicioCliente.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre",nullable = false)
    private String name;
    @Column(name = "apellido",nullable = false)
    private String lastName;
    @Column(name = "telefono",nullable = false, unique = true)
    private int  phone;
    @Column(name = "correo",nullable = false, unique = true)
    private String mail;


    @Override
    public String toString() {
        return "Cliente [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", mail=" + mail
                + "]";
    }

    

}
