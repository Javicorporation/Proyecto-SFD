package com.example.MicroservicioCliente.Service;

import java.util.List;

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

    public Cliente getClienteById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente saveCliente(Cliente cliente){
        Cliente newCliente = clienteRepository.save(cliente);
        return newCliente;
    }

}
