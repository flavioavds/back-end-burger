package com.burger.service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger.entities.Carne;
import com.burger.entities.IngredientesJson;
import com.burger.entities.Opcional;
import com.burger.entities.Pao;
import com.burger.repositories.CarneRepository;
import com.burger.repositories.OpcionalRepository;
import com.burger.repositories.PaoRepository;

@Service
public class IngredientesService {

    @Autowired
    private PaoRepository paoRepository;

    @Autowired
    private CarneRepository carneRepository;

    @Autowired
    private OpcionalRepository opcionalRepository;

    public void salvarIngredientes(IngredientesJson ingredientesJson) {
        for (Pao pao : ingredientesJson.getPaes()) {
            paoRepository.save(pao);
        }

        for (Carne carne : ingredientesJson.getCarnes()) {
            carneRepository.save(carne);
        }

        for (Opcional opcional : ingredientesJson.getOpcionais()) {
            opcionalRepository.save(opcional);
        }
    }
    
    public List<IngredientesJson> buscarTodosIngredientes() {
        // Busca todas as entidades Pao, Carne e Opcional no banco de dados
        List<Pao> paes = paoRepository.findAll();
        List<Carne> carnes = carneRepository.findAll();
        List<Opcional> opcionais = opcionalRepository.findAll();

        // Converte as entidades para o objeto IngredientesJson
        IngredientesJson ingredientesJson = IngredientesJson.builder()
            .paes(paes)
            .carnes(carnes)
            .opcionais(opcionais)
            .build();

        // Retorna a lista de IngredientesJson
        return Collections.singletonList(ingredientesJson);
    }

    public IngredientesJson buscarIngredientesPorId(UUID id) {
        // Busca as entidades Pao, Carne e Opcional por ID no banco de dados
        Pao pao = paoRepository.findById(id).orElse(null);
        Carne carne = carneRepository.findById(id).orElse(null);
        Opcional opcional = opcionalRepository.findById(id).orElse(null);

        // Verifica se foi encontrado algum dos ingredientes
        if (pao == null && carne == null && opcional == null) {
            return null; // Retorna null se nenhum ingrediente foi encontrado com o ID fornecido
        }

        // Cria o objeto IngredientesJson com os ingredientes encontrados
        return IngredientesJson.builder()
            .paes(pao != null ? Collections.singletonList(pao) : null)
            .carnes(carne != null ? Collections.singletonList(carne) : null)
            .opcionais(opcional != null ? Collections.singletonList(opcional) : null)
            .build();
    }    
}
