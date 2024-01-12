package com.example.MicroservicioCliente.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MicroservicioCliente.Entity.Cliente;
import com.example.MicroservicioCliente.Repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }

    public Optional getClienteById(Long id){
        return clienteRepository.findById(id);
    }

    public void saveCliente(Cliente cliente){
        clienteRepository.save(cliente);
        
    }

}
