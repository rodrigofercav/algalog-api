package com.msr.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.msr.algalog.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EntregaModel {

    private Long id;

    private ClienteResumoModel cliente;

    private DestinatarioModel destinatario;

    private BigDecimal taxa;

    private StatusEntrega status;

    private OffsetDateTime dataPedido;
    
    private OffsetDateTime dataFinalizacao;
}
