package com.example.MicroservicioProducto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroservicioProducto.Entity.Producto;
import com.example.MicroservicioProducto.Service.ProductoServicio;

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
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto ){
        Producto newProducto = productoServicio.save(producto);
        return ResponseEntity.ok(newProducto);
        
    }

    
}
