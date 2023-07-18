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
public class Odontologo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer matricula;
    private String nombre;
    private String apellido;

}
