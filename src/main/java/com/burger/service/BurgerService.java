package com.burger.service;

import java.util.List;
import java.util.UUID;

import com.burger.dtos.burger.BurgerDTORequest;
import com.burger.dtos.burger.BurgerDTOResponse;

public interface BurgerService {
	
	BurgerDTOResponse save(BurgerDTORequest dto);
	List<BurgerDTOResponse> findAll();
	BurgerDTOResponse findById(UUID id);
	BurgerDTOResponse update(UUID id, BurgerDTORequest dto);
	String delete(UUID id);

}
