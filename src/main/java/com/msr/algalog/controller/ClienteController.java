package com.msr.algalog.controller;

import java.util.List;

import com.msr.algalog.domain.model.Cliente;
import com.msr.algalog.domain.repository.ClienteRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {

        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

        return clienteRepository.findById(clienteId)
                // .map(cliente -> ResponseEntity.ok(cliente)) //outra forma
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

        /*
         * outra forma Optional<Cliente> cliente =
         * clienteRepository.findById(clienteId);
         * 
         * if (cliente.isPresent()) { return ResponseEntity.ok(cliente.get()); }
         * 
         * return ResponseEntity.notFound().build();
         */
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        
        return clienteRepository.save(cliente);
    }

}
