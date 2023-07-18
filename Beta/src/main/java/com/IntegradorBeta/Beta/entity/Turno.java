package com.IntegradorBeta.Beta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Turno {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Integer id;
    @ManyToOne
    @JoinColumn( name = "paciente_id", nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn( name = "odontologo_id", nullable = false)
    private Odontologo odontologo;
    private LocalDate fecha;
    private LocalTime hora;

}
