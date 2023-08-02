package com.burger.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burger.entities.Status;

public interface StatusRepository extends JpaRepository<Status, UUID>{

}
