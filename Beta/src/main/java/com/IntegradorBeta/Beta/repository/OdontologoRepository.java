package com.IntegradorBeta.Beta.repository;

import com.IntegradorBeta.Beta.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository <Odontologo , Integer > {
}
