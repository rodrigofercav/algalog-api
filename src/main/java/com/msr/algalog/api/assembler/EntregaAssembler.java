package com.msr.algalog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import com.msr.algalog.api.model.EntregaModel;
import com.msr.algalog.api.model.input.EntregaInput;
import com.msr.algalog.domain.model.Entrega;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega) {

        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {

        return entregas.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput) {
        
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
