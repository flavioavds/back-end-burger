package com.burger.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.dtos.carnes.CarneDTORequest;
import com.burger.dtos.carnes.CarneDTOResponse;
import com.burger.service.CarneService;

@RestController
@RequestMapping("/carnes")
@CrossOrigin(origins = "http://localhost:8080")
public class CarneController {

    private final CarneService carneService;

    public CarneController(CarneService carneService) {
        this.carneService = carneService;
    }

    @PostMapping
    public ResponseEntity<CarneDTOResponse> save(@RequestBody CarneDTORequest dto) {
        CarneDTOResponse response = carneService.save(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CarneDTOResponse>> findAll() {
        List<CarneDTOResponse> response = carneService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarneDTOResponse> findById(@PathVariable UUID id) {
        CarneDTOResponse response = carneService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarneDTOResponse> update(@PathVariable UUID id, @RequestBody CarneDTORequest dto) {
        CarneDTOResponse response = carneService.update(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        String message = carneService.delete(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}