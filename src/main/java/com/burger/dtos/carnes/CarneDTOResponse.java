package com.burger.dtos.carnes;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarneDTOResponse {
	
	private UUID id;
	private String tipo;

}
