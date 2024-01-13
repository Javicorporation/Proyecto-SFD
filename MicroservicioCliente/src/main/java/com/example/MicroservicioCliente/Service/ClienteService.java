package com.example.MicroservicioCliente.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.MicroservicioCliente.Entity.Cliente;
import com.example.MicroservicioCliente.Repository.ClienteRepository;

@Service
public class ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RestTemplate restTemplate;

  
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    
    public Cliente getByID(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    
    

}
