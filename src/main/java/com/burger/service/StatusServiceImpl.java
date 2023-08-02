package com.burger.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.burger.dtos.status.StatusDTORequest;
import com.burger.dtos.status.StatusDTOResponse;
import com.burger.dtos.status.StatusMapper;
import com.burger.entities.Status;
import com.burger.repositories.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{
	
	private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public StatusDTOResponse save(StatusDTORequest dto) {
        Status status = StatusMapper.fromDTO(dto);
        Status savedStatus = statusRepository.save(status);
        return StatusMapper.toDTO(savedStatus);
    }

    @Override
    public List<StatusDTOResponse> findAll() {
        List<Status> statusList = statusRepository.findAll();
        return statusList.stream().map(StatusMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public StatusDTOResponse findById(UUID id) {
        Status status = statusRepository.findById(id).orElse(null);
        if (status != null) {
            return StatusMapper.toDTO(status);
        }
        throw new NoSuchElementException("Carne not found with ID: " + id);
    }

    @Override
    public StatusDTOResponse update(UUID id, StatusDTORequest dto) {
        Status existingStatus = statusRepository.findById(id).orElse(null);
        if (existingStatus == null) {
            throw new NoSuchElementException("Carne not found with ID: " + id);
        }

        Status updatedStatus = StatusMapper.fromDTO(dto);
        updatedStatus.setId(id);
        Status savedStatus = statusRepository.save(updatedStatus);
        return StatusMapper.toDTO(savedStatus);
    }

    @Override
    public String delete(UUID id) {
        Status existingStatus = statusRepository.findById(id).orElse(null);
        if (existingStatus == null) {
            throw new NoSuchElementException("Carne not found with ID: " + id);
        }

        statusRepository.deleteById(id);
        return "Carne with ID " + id + " has been deleted.";
    }

}
