package com.msr.algalog.api.model.input;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.msr.algalog.domain.model.Destinatario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaInput {
    
    @NotNull
    private Long clienteId;

    @Valid
    @NotNull
    private DestinatarioInput destinatario;

    @NotNull
    private BigDecimal taxa;
}
