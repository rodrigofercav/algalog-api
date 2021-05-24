package com.msr.algalog.domain.service;

import com.msr.algalog.domain.exception.NegocioException;
import com.msr.algalog.domain.model.Entrega;
import com.msr.algalog.domain.repository.EntregaRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {
    
    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new NegocioException("Entrega não encontrada"));
    }
}
