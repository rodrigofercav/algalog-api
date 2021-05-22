package com.msr.algalog.domain.service;

import com.msr.algalog.domain.exception.NegocioException;
import com.msr.algalog.domain.model.Cliente;
import com.msr.algalog.domain.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailJaCadastrado = clienteRepository.findByEmail(cliente.getEmail()).stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if (emailJaCadastrado) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

}
