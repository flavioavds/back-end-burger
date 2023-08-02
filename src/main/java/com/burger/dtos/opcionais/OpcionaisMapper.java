package com.burger.dtos.opcionais;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.burger.entities.Opcional;

public class OpcionaisMapper {

    public static Opcional fromDTO(OpcionaisDTORequest dto) {
        Opcional opcional = new Opcional();
        BeanUtils.copyProperties(dto, opcional);
        return opcional;
    }

    public static OpcionaisDTOResponse toDTO(Opcional entity) {
        OpcionaisDTOResponse res = new OpcionaisDTOResponse();
        BeanUtils.copyProperties(entity, res);
        return res;
    }

    public static List<Opcional> fromDTOtoList(List<OpcionaisDTORequest> dtoList) {
        return dtoList.stream()
                .map(OpcionaisMapper::fromDTO)
                .collect(Collectors.toList());
    }

    public static List<Opcional> fromUUIDtoList(List<UUID> uuidList) {
        return uuidList.stream()
                .map(uuid -> {
                    Opcional opcional = new Opcional();
                    opcional.setId(uuid); // Assuming the UUID is used as the ID of Opcional
                    return opcional;
                })
                .collect(Collectors.toList());
    }
}
