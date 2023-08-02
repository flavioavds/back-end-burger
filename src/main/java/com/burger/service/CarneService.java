package com.burger.service;

import java.util.List;
import java.util.UUID;

import com.burger.dtos.carnes.CarneDTORequest;
import com.burger.dtos.carnes.CarneDTOResponse;

public interface CarneService {
	
	CarneDTOResponse save(CarneDTORequest dto);
	List<CarneDTOResponse> findAll();
	CarneDTOResponse findById(UUID id);
	CarneDTOResponse update(UUID id, CarneDTORequest dto);
	String delete(UUID id);
	

}
