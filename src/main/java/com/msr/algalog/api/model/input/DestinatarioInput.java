package com.msr.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String logradouro;
    
    @NotBlank
    private String numero;
    
    private String complemento;
    
    @NotBlank
    private String bairro;
}
