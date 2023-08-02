package com.burger.dtos.paes;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaoDTOResponse {

	private UUID id;
	private String tipo;
	
}
