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

import com.burger.dtos.paes.PaoDTORequest;
import com.burger.dtos.paes.PaoDTOResponse;
import com.burger.service.PaoService;

@RestController
@RequestMapping("/paes")
@CrossOrigin(origins = "http://localhost:8080")
public class PaoController {
	
	private final PaoService paoService;

    public PaoController(PaoService paoService) {
        this.paoService = paoService;
    }

    @PostMapping
    public ResponseEntity<PaoDTOResponse> save(@RequestBody PaoDTORequest dto) {
    	PaoDTOResponse response = paoService.save(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PaoDTOResponse>> findAll() {
        List<PaoDTOResponse> response = paoService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaoDTOResponse> findById(@PathVariable UUID id) {
    	PaoDTOResponse response = paoService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaoDTOResponse> update(@PathVariable UUID id, @RequestBody PaoDTORequest dto) {
    	PaoDTOResponse response = paoService.update(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        String message = paoService.delete(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
