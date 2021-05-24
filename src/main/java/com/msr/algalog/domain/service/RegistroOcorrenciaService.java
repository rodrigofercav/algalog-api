package com.msr.algalog.domain.service;

import com.msr.algalog.domain.model.Entrega;
import com.msr.algalog.domain.model.Ocorrencia;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        
        return entrega.adicionarOcorrencia(descricao);
    }
}
