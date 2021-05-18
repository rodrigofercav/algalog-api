package com.msr.algalog.controller;

import java.util.Arrays;
import java.util.List;

import com.msr.algalog.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {

        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Cliente 1");
        cliente1.setEmail("cliente1@email.com");
        cliente1.setTelefone("(99) 99999-9999");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Cliente 2");
        cliente2.setEmail("cliente2@email.com");
        cliente2.setTelefone("(88) 88888-8888");

        Cliente cliente3 = new Cliente();
        cliente3.setId(3L);
        cliente3.setNome("Cliente 3");
        cliente3.setEmail("cliente3@email.com");
        cliente3.setTelefone("(77) 77777-7777");

        return Arrays.asList(cliente1, cliente2, cliente3);
    }

}
