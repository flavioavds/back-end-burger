package com.burger.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "burgers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Burger {

	@Id
	@GeneratedValue
	private UUID id;
	private String nome;

	@ManyToOne
	@JoinColumn(name = "carne_id") 
	@JsonIgnoreProperties("burgers")
	private Carne carne;

	@ManyToOne
	@JoinColumn(name = "pao_id") 
	private Pao pao;

	@ManyToMany
	@JoinTable(
		name = "burger_opcional",
		joinColumns = @JoinColumn(name = "burger_id"),
		inverseJoinColumns = @JoinColumn(name = "opcional_id")
	)
	private List<Opcional> opcionais;

	@ManyToOne
	@JoinColumn(name = "status_id") 
	private Status status;
}
