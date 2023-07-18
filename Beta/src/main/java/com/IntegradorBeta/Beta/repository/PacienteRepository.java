package com.IntegradorBeta.Beta.repository;

import com.IntegradorBeta.Beta.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente , Integer > {
}
