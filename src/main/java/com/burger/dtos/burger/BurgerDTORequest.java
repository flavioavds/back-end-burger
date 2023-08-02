package com.burger.dtos.burger;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BurgerDTORequest {
    private String nome;
    private UUID carne;
    private UUID pao;
    private List<UUID> opcionais;
    private UUID status;
}
