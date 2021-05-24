package com.msr.algalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@Getter
@Setter
public class Problema {
    
    private Integer status;
    private OffsetDateTime dataHora;
    private String titulo;
    private List<Campo> campos;
}
