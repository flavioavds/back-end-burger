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

import com.burger.dtos.opcionais.OpcionaisDTORequest;
import com.burger.dtos.opcionais.OpcionaisDTOResponse;
import com.burger.service.OpcionalService;

@RestController
@RequestMapping("/opcionais")
@CrossOrigin(origins = "http://localhost:8080")
public class OpcionalController {

    private final OpcionalService opcionalService;

    public OpcionalController(OpcionalService opcionalService) {
        this.opcionalService = opcionalService;
    }

    @PostMapping
    public ResponseEntity<OpcionaisDTOResponse> save(@RequestBody OpcionaisDTORequest dto) {
        OpcionaisDTOResponse response = opcionalService.save(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OpcionaisDTOResponse>> findAll() {
        List<OpcionaisDTOResponse> response = opcionalService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpcionaisDTOResponse> findById(@PathVariable UUID id) {
        OpcionaisDTOResponse response = opcionalService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpcionaisDTOResponse> update(@PathVariable UUID id, @RequestBody OpcionaisDTORequest dto) {
        OpcionaisDTOResponse response = opcionalService.update(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        String message = opcionalService.delete(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
