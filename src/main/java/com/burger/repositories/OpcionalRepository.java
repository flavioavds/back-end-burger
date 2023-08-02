package com.burger.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burger.entities.Opcional;

public interface OpcionalRepository extends JpaRepository<Opcional, UUID> {


}
