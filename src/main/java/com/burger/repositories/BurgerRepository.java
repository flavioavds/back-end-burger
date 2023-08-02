package com.burger.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.burger.entities.Burger;

public interface BurgerRepository extends JpaRepository<Burger, UUID> {

}
