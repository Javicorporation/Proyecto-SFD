package com.example.MicroservicioProducto.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroservicioProducto.Entity.Producto;
import com.example.MicroservicioProducto.Entity.Validation.Error;
import com.example.MicroservicioProducto.Service.ProductoServicio;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apiProducto")
public class ProductoController {

    @Autowired
    ProductoServicio productoServicio;

    @GetMapping
    public ResponseEntity <List<Producto>> traeTodo(){
        List<Producto> todo = productoServicio.getAll();
        if(todo.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(todo);
        
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> traerPorId(@PathVariable("id") Long id){
        Producto traeUno = productoServicio.getById(id);
        if(traeUno == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(traeUno);

    }


    @PostMapping()
    public ResponseEntity<?> guardar(@Valid @RequestBody Producto producto, BindingResult result ){
        if(result.hasErrors()){
            List<String> messages = result.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
            String errorMessage = String.join(", ", messages);
            return ResponseEntity.badRequest().body(new Error("valid Error", errorMessage));
        }
        Producto newProducto = productoServicio.save(producto);
        return ResponseEntity.ok(newProducto);
        
    }

    
}
