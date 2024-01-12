package com.example.MicroservicioCliente.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "este nombre no puede estar vacio")
    @NotBlank(message = "este nombre no puede ser nulo")
    @Column(name = "nombre",nullable = false)
    private String name;

    @NotNull(message = "este apellido no puede estar vacio")
    @NotBlank(message = "este apellido no puede ser nulo")
    @Column(name = "apellido",nullable = false)
    private String lastName;

    @NotNull(message = "este telefono no puede estar vacio")
    @Column(name = "telefono",nullable = false, unique = true)
    private int  phone;

    @Email
    @NotBlank(message = "este correo no puede ser nulo")
    @Column(name = "correo",nullable = false, unique = true)
    private String mail;


    @Override
    public String toString() {
        return "Cliente [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", mail=" + mail
                + "]";
    }

    

}
