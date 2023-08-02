package com.burger.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.burger.dtos.carnes.CarneDTORequest;
import com.burger.dtos.carnes.CarneDTOResponse;
import com.burger.dtos.carnes.CarneMapper;
import com.burger.entities.Carne;
import com.burger.repositories.CarneRepository;

@Service
public class CarneServiceImpl implements CarneService {

    private final CarneRepository carneRepository;

    public CarneServiceImpl(CarneRepository carneRepository) {
        this.carneRepository = carneRepository;
    }

    @Override
    public CarneDTOResponse save(CarneDTORequest dto) {
        Carne carne = CarneMapper.fromDTO(dto);
        Carne savedCarne = carneRepository.save(carne);
        return CarneMapper.toDTO(savedCarne);
    }

    @Override
    public List<CarneDTOResponse> findAll() {
        List<Carne> carneList = carneRepository.findAll();
        return carneList.stream().map(CarneMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CarneDTOResponse findById(UUID id) {
        Carne carne = carneRepository.findById(id).orElse(null);
        if (carne != null) {
            return CarneMapper.toDTO(carne);
        }
        throw new NoSuchElementException("Carne not found with ID: " + id);
    }

    @Override
    public CarneDTOResponse update(UUID id, CarneDTORequest dto) {
        Carne existingCarne = carneRepository.findById(id).orElse(null);
        if (existingCarne == null) {
            throw new NoSuchElementException("Carne not found with ID: " + id);
        }

        Carne updatedCarne = CarneMapper.fromDTO(dto);
        updatedCarne.setId(id);
        Carne savedCarne = carneRepository.save(updatedCarne);
        return CarneMapper.toDTO(savedCarne);
    }

    @Override
    public String delete(UUID id) {
        Carne existingCarne = carneRepository.findById(id).orElse(null);
        if (existingCarne == null) {
            throw new NoSuchElementException("Carne not found with ID: " + id);
        }

        carneRepository.deleteById(id);
        return "Carne with ID " + id + " has been deleted.";
    }
}
