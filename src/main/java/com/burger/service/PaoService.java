package com.burger.service;

import java.util.List;
import java.util.UUID;

import com.burger.dtos.paes.PaoDTORequest;
import com.burger.dtos.paes.PaoDTOResponse;

public interface PaoService {
	
	PaoDTOResponse save(PaoDTORequest dto);
	List<PaoDTOResponse> findAll();
	PaoDTOResponse findById(UUID id);
	PaoDTOResponse update(UUID id, PaoDTORequest dto);
	String delete(UUID id);

}
