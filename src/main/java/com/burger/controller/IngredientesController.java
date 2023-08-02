package com.burger.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.burger.entities.IngredientesJson;
import com.burger.service.IngredientesService;

@RestController
public class IngredientesController {

    @Autowired
    private IngredientesService ingredientesService;

    @PostMapping
    public ResponseEntity<String> criarIngredientes(@RequestBody IngredientesJson ingredientesJson) {
        ingredientesService.salvarIngredientes(ingredientesJson);
        return ResponseEntity.ok("Ingredientes criados com sucesso!");
    }
    
    @CrossOrigin(origins = "https://strong-paletas-b4b962.netlify.app")
    @GetMapping("/ingredientes")
    public ResponseEntity<List<IngredientesJson>> getAllIngredientes() {
        List<IngredientesJson> ingredientesList = ingredientesService.buscarTodosIngredientes();
        return ResponseEntity.ok(ingredientesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientesJson> getIngredientesById(@PathVariable UUID id) {
        IngredientesJson ingredientesJson = ingredientesService.buscarIngredientesPorId(id);
        if (ingredientesJson != null) {
            return ResponseEntity.ok(ingredientesJson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}