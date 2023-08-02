package com.burger.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.burger.dtos.burger.BurgerDTORequest;
import com.burger.dtos.burger.BurgerDTOResponse;
import com.burger.service.BurgerService;

@RestController
@RequestMapping("/burgers")
public class BurgerController {

    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    @CrossOrigin(origins = "https://strong-paletas-b4b962.netlify.app/")
    @PostMapping
    public ResponseEntity<BurgerDTOResponse> save(@RequestBody BurgerDTORequest dto) {
        BurgerDTOResponse response = burgerService.save(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "https://strong-paletas-b4b962.netlify.app/")
    @GetMapping
    public ResponseEntity<List<BurgerDTOResponse>> findAll() {
        List<BurgerDTOResponse> response = burgerService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://strong-paletas-b4b962.netlify.app/")
    @GetMapping("/{id}")
    public ResponseEntity<BurgerDTOResponse> findById(@PathVariable UUID id) {
        BurgerDTOResponse response = burgerService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://strong-paletas-b4b962.netlify.app/")
    @PatchMapping("/{id}")
    public ResponseEntity<BurgerDTOResponse> update(@PathVariable UUID id, @RequestBody BurgerDTORequest dto) {
        BurgerDTOResponse response = burgerService.update(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://strong-paletas-b4b962.netlify.app/")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        String message = burgerService.delete(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

