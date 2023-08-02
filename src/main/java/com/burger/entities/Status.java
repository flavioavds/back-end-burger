package com.burger.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "status")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Status {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String tipo;

}
