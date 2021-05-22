package com.msr.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.msr.algalog.domain.model.Cliente;
import com.msr.algalog.domain.repository.ClienteRepository;
import com.msr.algalog.domain.service.CatalogoClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> listar() {

        return clienteRepository.findAll(); // 200
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

        return clienteRepository.findById(clienteId)
                // .map(cliente -> ResponseEntity.ok(cliente)) // 200 //outra forma
                .map(ResponseEntity::ok) // 200
                .orElse(ResponseEntity.notFound().build()); // 404

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
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        System.out.println("entrou no adicionar.");
        //return clienteRepository.save(cliente);
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {

        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        //cliente = clienteRepository.save(cliente);
        catalogoClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente); // 200
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {

        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        //clienteRepository.deleteById(clienteId);
        catalogoClienteService.excluir(clienteId);

        return ResponseEntity.noContent().build(); // 204
    }
}