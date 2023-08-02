package com.burger.dtos.opcionais;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpcionaisDTOResponse {
	
	private UUID id;
	private String tipo;

}
