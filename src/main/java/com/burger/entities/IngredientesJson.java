package com.burger.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IngredientesJson {
	
	private List<Pao> paes;
    private List<Carne> carnes;
    private List<Opcional> opcionais;

}
