package com.msr.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.msr.algalog.api.assembler.EntregaAssembler;
import com.msr.algalog.api.model.EntregaModel;
import com.msr.algalog.api.model.input.EntregaInput;
import com.msr.algalog.domain.model.Entrega;
import com.msr.algalog.domain.repository.EntregaRepository;
import com.msr.algalog.domain.service.SolicitacaoEntregaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {

        return entregaAssembler.toModel(solicitacaoEntregaService.solicitar(entregaAssembler.toEntity(entregaInput)));
    }

    @GetMapping
    public List<EntregaModel> listar() {

        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {

        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
