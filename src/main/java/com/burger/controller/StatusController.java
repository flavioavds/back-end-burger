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

import com.burger.dtos.status.StatusDTORequest;
import com.burger.dtos.status.StatusDTOResponse;
import com.burger.service.StatusService;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:8080")
public class StatusController {
	
	private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity<StatusDTOResponse> save(@RequestBody StatusDTORequest dto) {
    	StatusDTOResponse response = statusService.save(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StatusDTOResponse>> findAll() {
        List<StatusDTOResponse> response = statusService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTOResponse> findById(@PathVariable UUID id) {
    	StatusDTOResponse response = statusService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTOResponse> update(@PathVariable UUID id, @RequestBody StatusDTORequest dto) {
    	StatusDTOResponse response = statusService.update(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        String message = statusService.delete(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
