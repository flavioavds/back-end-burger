package com.burger.dtos.paes;

import java.util.UUID;

import com.burger.entities.Pao;

public class PaoMapper {
    public static Pao fromDTO(PaoDTORequest dto) {
        Pao pao = new Pao();
        pao.setTipo(dto.getTipo());
        return pao;
    }

    public static Pao fromDTO(UUID id) {
        Pao pao = new Pao();
        pao.setId(id);
        return pao;
    }

    public static PaoDTOResponse toDTO(Pao entity) {
        PaoDTOResponse res = new PaoDTOResponse();
        res.setId(entity.getId());
        res.setTipo(entity.getTipo());
        return res;
    }
}
