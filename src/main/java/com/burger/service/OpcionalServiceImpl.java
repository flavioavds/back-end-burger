package com.burger.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.burger.dtos.opcionais.OpcionaisDTORequest;
import com.burger.dtos.opcionais.OpcionaisDTOResponse;
import com.burger.dtos.opcionais.OpcionaisMapper;
import com.burger.entities.Opcional;
import com.burger.repositories.OpcionalRepository;

@Service
public class OpcionalServiceImpl implements OpcionalService {

    private final OpcionalRepository opcionalRepository;

    public OpcionalServiceImpl(OpcionalRepository opcionalRepository) {
        this.opcionalRepository = opcionalRepository;
    }

    @Override
    public OpcionaisDTOResponse save(OpcionaisDTORequest dto) {
        Opcional opcional = OpcionaisMapper.fromDTO(dto);
        Opcional savedOpcional = opcionalRepository.save(opcional);
        return OpcionaisMapper.toDTO(savedOpcional);
    }

    @Override
    public List<OpcionaisDTOResponse> findAll() {
        List<Opcional> opcionalList = opcionalRepository.findAll();
        return opcionalList.stream().map(OpcionaisMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public OpcionaisDTOResponse findById(UUID id) {
        Opcional opcional = opcionalRepository.findById(id).orElse(null);
        if (opcional != null) {
            return OpcionaisMapper.toDTO(opcional);
        }
        throw new NoSuchElementException("Opcional not found with ID: " + id);
    }

    @Override
    public OpcionaisDTOResponse update(UUID id, OpcionaisDTORequest dto) {
        Opcional existingOpcional = opcionalRepository.findById(id).orElse(null);
        if (existingOpcional == null) {
            throw new NoSuchElementException("Opcional not found with ID: " + id);
        }

        Opcional updatedOpcional = OpcionaisMapper.fromDTO(dto);
        updatedOpcional.setId(id);
        Opcional savedOpcional = opcionalRepository.save(updatedOpcional);
        return OpcionaisMapper.toDTO(savedOpcional);
    }

    @Override
    public String delete(UUID id) {
        Opcional existingOpcional = opcionalRepository.findById(id).orElse(null);
        if (existingOpcional == null) {
            throw new NoSuchElementException("Opcional not found with ID: " + id);
        }

        opcionalRepository.deleteById(id);
        return "Opcional with ID " + id + " has been deleted.";
    }
}
