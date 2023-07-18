package com.IntegradorBeta.Beta.repository;

import com.IntegradorBeta.Beta.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository <Turno, Integer > {
}
