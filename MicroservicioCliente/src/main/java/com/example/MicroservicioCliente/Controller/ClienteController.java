package com.example.MicroservicioCliente.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MicroservicioCliente.Entity.Cliente;
import com.example.MicroservicioCliente.Service.ClienteService;

@RestController
@RequestMapping("/apiCliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> traerTodo(){
        List<Cliente> traeTodo = clienteService.getAll();
        if(traeTodo.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(traeTodo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> traeUno(@PathVariable("id") Long id){
        Cliente traerUno = clienteService.getClienteById(id);
        if(traerUno == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(traerUno);
    }

    @PostMapping()
    public ResponseEntity <Cliente> guardar(@RequestBody Cliente cliente){
        Cliente newCliente = clienteService.saveCliente(cliente);
        return ResponseEntity.ok(newCliente);
    }

}
