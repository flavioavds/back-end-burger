package com.burger.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.burger.dtos.paes.PaoDTORequest;
import com.burger.dtos.paes.PaoDTOResponse;
import com.burger.dtos.paes.PaoMapper;
import com.burger.entities.Pao;
import com.burger.repositories.PaoRepository;

@Service
public class PaoServiceImpl implements PaoService{
	
	private final PaoRepository paoRepository;

    public PaoServiceImpl(PaoRepository paoRepository) {
        this.paoRepository = paoRepository;
    }

    @Override
    public PaoDTOResponse save(PaoDTORequest dto) {
        Pao pao = PaoMapper.fromDTO(dto);
        Pao savedPao = paoRepository.save(pao);
        return PaoMapper.toDTO(savedPao);
    }

    @Override
    public List<PaoDTOResponse> findAll() {
        List<Pao> paoList = paoRepository.findAll();
        return paoList.stream().map(PaoMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PaoDTOResponse findById(UUID id) {
        Pao pao = paoRepository.findById(id).orElse(null);
        if (pao != null) {
            return PaoMapper.toDTO(pao);
        }
        throw new NoSuchElementException("Carne not found with ID: " + id);
    }

    @Override
    public PaoDTOResponse update(UUID id, PaoDTORequest dto) {
        Pao existingPao = paoRepository.findById(id).orElse(null);
        if (existingPao == null) {
            throw new NoSuchElementException("Carne not found with ID: " + id);
        }

        Pao updatedPao = PaoMapper.fromDTO(dto);
        updatedPao.setId(id);
        Pao savedPao = paoRepository.save(updatedPao);
        return PaoMapper.toDTO(savedPao);
    }

    @Override
    public String delete(UUID id) {
        Pao existingPao = paoRepository.findById(id).orElse(null);
        if (existingPao == null) {
            throw new NoSuchElementException("Carne not found with ID: " + id);
        }

        paoRepository.deleteById(id);
        return "Carne with ID " + id + " has been deleted.";
    }

}
