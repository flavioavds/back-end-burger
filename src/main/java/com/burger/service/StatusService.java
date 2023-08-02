package com.burger.service;

import java.util.List;
import java.util.UUID;

import com.burger.dtos.status.StatusDTORequest;
import com.burger.dtos.status.StatusDTOResponse;

public interface StatusService {
	
	StatusDTOResponse save(StatusDTORequest dto);
	List<StatusDTOResponse> findAll();
	StatusDTOResponse findById(UUID id);
	StatusDTOResponse update(UUID id, StatusDTORequest dto);
	String delete(UUID id);

}
