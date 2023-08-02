package com.burger.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burger.entities.Carne;

public interface CarneRepository extends JpaRepository<Carne, UUID> {

}
