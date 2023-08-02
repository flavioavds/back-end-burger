package com.burger.dtos.carnes;

import java.util.UUID;

import com.burger.entities.Carne;

public class CarneMapper {
    public static Carne fromDTO(CarneDTORequest dto){
        Carne carne = new Carne();
        carne.setTipo(dto.getTipo());
        return carne;        
    }

    public static Carne fromDTO(UUID id) {
        Carne carne = new Carne();
        carne.setId(id);
        return carne;
    }

    public static CarneDTOResponse toDTO(Carne entity) {
        CarneDTOResponse res = new CarneDTOResponse();
        res.setId(entity.getId());
        res.setTipo(entity.getTipo());
        return res;
    }
}
