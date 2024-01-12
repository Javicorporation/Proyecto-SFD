package com.example.MicroservicioFactura.Controller;

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

import com.example.MicroservicioFactura.Entity.Factura;
import com.example.MicroservicioFactura.Entity.Validation.Error;
import com.example.MicroservicioFactura.Service.FacturaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/apiFactura")
public class facturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping
    public ResponseEntity <List<Factura>> traerTodo(){
        List<Factura> todo = facturaService.getAll();
        if(todo.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(todo);
    }


    @GetMapping("/{id}")
    public ResponseEntity <Factura> traerPorId(@PathVariable("id") Long id){
        Factura traeUno = facturaService.getById(id);
        if(traeUno == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(traeUno);

    }


    @PostMapping()
    public ResponseEntity <?> guardar (@Valid @RequestBody Factura factura, BindingResult result){
        if(result.hasErrors()){
            List<String> messages = result.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
            String errorMessage = String.join(", ", messages);
            return ResponseEntity.badRequest().body(new Error("validation Error", errorMessage));

        }
        Factura newFactura = facturaService.save(factura);
        return ResponseEntity.ok(newFactura);
    }


}
