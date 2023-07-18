package com.IntegradorBeta.Beta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Paciente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Integer id;
    private String nombre;
    private String apellido;
    private String mail;
    private Integer dni;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn( name = "domicilio_id")
    private Domicilio domicilio;
}
