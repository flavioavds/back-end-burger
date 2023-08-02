package com.burger.dtos.opcionais;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpcionaisDTORequest {
	
	private String tipo;
	
}
