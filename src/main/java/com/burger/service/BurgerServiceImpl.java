package com.burger.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.burger.dtos.burger.BurgerDTORequest;
import com.burger.dtos.burger.BurgerDTOResponse;
import com.burger.dtos.burger.BurgerMapper;
import com.burger.entities.Burger;
import com.burger.repositories.BurgerRepository;
import com.burger.repositories.CarneRepository;
import com.burger.repositories.OpcionalRepository;
import com.burger.repositories.PaoRepository;
import com.burger.repositories.StatusRepository;

@Service
public class BurgerServiceImpl implements BurgerService {

	private final BurgerRepository burgerRepository;
    private final CarneRepository carneRepository;
    private final PaoRepository paoRepository;
    private final OpcionalRepository opcionaisRepository;
    private final StatusRepository statusRepository;

    public BurgerServiceImpl(BurgerRepository burgerRepository, CarneRepository carneRepository, PaoRepository paoRepository, OpcionalRepository opcionaisRepository, StatusRepository statusRepository) {
        this.burgerRepository = burgerRepository;
        this.carneRepository = carneRepository;
        this.paoRepository = paoRepository;
        this.opcionaisRepository = opcionaisRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public BurgerDTOResponse save(BurgerDTORequest dto) {
        Burger burger = BurgerMapper.fromDTO(dto, carneRepository, paoRepository, opcionaisRepository, statusRepository);
        Burger savedBurger = burgerRepository.save(burger);
        return BurgerMapper.toDTO(savedBurger);
    }

    @Override
    public List<BurgerDTOResponse> findAll() {
        List<Burger> burgerList = burgerRepository.findAll();
        return burgerList.stream().map(BurgerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public BurgerDTOResponse findById(UUID id) {
        Burger burger = burgerRepository.findById(id).orElse(null);
        if (burger != null) {
            return BurgerMapper.toDTO(burger);
        }
        throw new NoSuchElementException("Burger not found with ID: " + id);
    }
    
    @Override
    public BurgerDTOResponse update(UUID id, BurgerDTORequest dto) {
        Burger existingBurger = burgerRepository.findById(id).orElse(null);
        if (existingBurger == null) {
            throw new NoSuchElementException("Burger not found with ID: " + id);
        }

        if (dto.getStatus() != null) {
            existingBurger.setStatus(statusRepository.findById(dto.getStatus()).orElse(null));
        }

        Burger savedBurger = burgerRepository.save(existingBurger);
        return BurgerMapper.toDTO(savedBurger);
    }

    @Override
    public String delete(UUID id) {
        Burger existingBurger = burgerRepository.findById(id).orElse(null);
        if (existingBurger == null) {
            throw new NoSuchElementException("Burger not found with ID: " + id);
        }

        burgerRepository.deleteById(id);
        return "Burger with ID " + id + " has been deleted.";
    }
}
