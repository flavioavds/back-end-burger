package com.burger.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burger.entities.Pao;

public interface PaoRepository extends JpaRepository<Pao, UUID>{	

}
