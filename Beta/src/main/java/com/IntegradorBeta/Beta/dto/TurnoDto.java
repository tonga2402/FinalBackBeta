package com.IntegradorBeta.Beta.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor

public class TurnoDto {

    private Integer id;
    private OdontologoDto odontologo;
    private PacienteDto paciente;
    private LocalDate fecha;
    private LocalTime hora;
}
