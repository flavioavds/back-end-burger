package com.burger.dtos.burger;

import java.util.List;
import java.util.UUID;

import com.burger.dtos.carnes.CarneDTOResponse;
import com.burger.dtos.opcionais.OpcionaisDTOResponse;
import com.burger.dtos.paes.PaoDTOResponse;
import com.burger.dtos.status.StatusDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerDTOResponse {
	
	private UUID id;
    private String nome;
    private CarneDTOResponse carne;
    private PaoDTOResponse pao;
    private List<OpcionaisDTOResponse> opcionais;
    private StatusDTOResponse status;
    
}
