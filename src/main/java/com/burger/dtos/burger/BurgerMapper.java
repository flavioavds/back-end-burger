package com.burger.dtos.burger;

import java.util.List;
import java.util.stream.Collectors;

import com.burger.dtos.carnes.CarneDTOResponse;
import com.burger.dtos.carnes.CarneMapper;
import com.burger.dtos.opcionais.OpcionaisDTOResponse;
import com.burger.dtos.opcionais.OpcionaisMapper;
import com.burger.dtos.paes.PaoDTOResponse;
import com.burger.dtos.paes.PaoMapper;
import com.burger.dtos.status.StatusDTOResponse;
import com.burger.dtos.status.StatusMapper;
import com.burger.entities.Burger;
import com.burger.entities.Carne;
import com.burger.entities.Opcional;
import com.burger.entities.Pao;
import com.burger.entities.Status;
import com.burger.repositories.CarneRepository;
import com.burger.repositories.OpcionalRepository;
import com.burger.repositories.PaoRepository;
import com.burger.repositories.StatusRepository;

public class BurgerMapper {

    public static Burger fromDTO(BurgerDTORequest dto, CarneRepository carneRepository, PaoRepository paoRepository, OpcionalRepository opcionaisRepository, StatusRepository statusRepository) {
        Burger burger = new Burger();
        burger.setNome(dto.getNome());

        if (dto.getCarne() != null) {
            Carne carne = carneRepository.findById(dto.getCarne()).orElse(null);
            burger.setCarne(carne);
        }

        if (dto.getPao() != null) {
            Pao pao = paoRepository.findById(dto.getPao()).orElse(null);
            burger.setPao(pao);
        }

        if (dto.getOpcionais() != null) {
            List<Opcional> opcionais = opcionaisRepository.findAllById(dto.getOpcionais());
            burger.setOpcionais(opcionais);
        }

        if (dto.getStatus() != null) {
            Status status = statusRepository.findById(dto.getStatus()).orElse(null);
            burger.setStatus(status);
        }

        return burger;
    }

    public static BurgerDTOResponse toDTO(Burger entity) {
        BurgerDTOResponse res = new BurgerDTOResponse();
        res.setId(entity.getId());
        res.setNome(entity.getNome());

        if (entity.getCarne() != null) {
            CarneDTOResponse carne = CarneMapper.toDTO(entity.getCarne());
            res.setCarne(carne);
        }

        if (entity.getPao() != null) {
            PaoDTOResponse pao = PaoMapper.toDTO(entity.getPao());
            res.setPao(pao);
        }

        if (entity.getOpcionais() != null) {
            List<OpcionaisDTOResponse> opcionais = entity.getOpcionais().stream()
                    .map(OpcionaisMapper::toDTO)
                    .collect(Collectors.toList());
            res.setOpcionais(opcionais);
        }

        if (entity.getStatus() != null) {
            StatusDTOResponse status = StatusMapper.toDTO(entity.getStatus());
            res.setStatus(status);
        }

        return res;
    }
}
