package com.IntegradorBeta.Beta.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class PacienteDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private String mail;
    private Integer dni;
}
