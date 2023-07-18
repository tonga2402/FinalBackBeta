package com.IntegradorBeta.Beta.repository;

import com.IntegradorBeta.Beta.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio , Integer > {
}
