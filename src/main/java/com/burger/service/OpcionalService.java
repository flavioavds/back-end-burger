package com.burger.service;

import java.util.List;
import java.util.UUID;

import com.burger.dtos.opcionais.OpcionaisDTORequest;
import com.burger.dtos.opcionais.OpcionaisDTOResponse;

public interface OpcionalService {
	
	OpcionaisDTOResponse save(OpcionaisDTORequest dto);
	List<OpcionaisDTOResponse> findAll();
	OpcionaisDTOResponse findById(UUID id);
	OpcionaisDTOResponse update(UUID id, OpcionaisDTORequest dto);
	String delete(UUID id);

}
