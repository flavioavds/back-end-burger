package com.burger.dtos.status;

import java.util.UUID;

import com.burger.entities.Status;

public class StatusMapper {
    public static Status fromDTO(StatusDTORequest dto) {
        Status status = new Status();
        status.setTipo(dto.getTipo());
        return status;
    }

    public static Status fromDTO(UUID id) {
        Status status = new Status();
        status.setId(id);
        return status;
    }

    public static StatusDTOResponse toDTO(Status entity) {
        StatusDTOResponse res = new StatusDTOResponse();
        res.setId(entity.getId());
        res.setTipo(entity.getTipo());
        return res;
    }
}

