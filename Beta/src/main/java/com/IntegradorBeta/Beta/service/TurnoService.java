package com.IntegradorBeta.Beta.service;


import com.IntegradorBeta.Beta.dto.TurnoDto;

import com.IntegradorBeta.Beta.entity.Turno;
import com.IntegradorBeta.Beta.exceptions.BadRequestException;
import com.IntegradorBeta.Beta.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class TurnoService implements AppService <Turno , TurnoDto > {

    private static final Logger LOGGER = Logger.getLogger(TurnoService.class);
    @Autowired
    TurnoRepository turnoRepository;


    @Autowired
    ObjectMapper mapper;


    @Override
    public TurnoDto agregar(Turno turno) throws BadRequestException {
        LOGGER.debug("inicio TurnoDto agregar");
        if (turno.getPaciente() == null || turno.getOdontologo() == null) {
            throw new BadRequestException("code 01" , "Los campos no pueden ser nulos");
        }
        LOGGER.debug("Turno creado");
        Turno turno1 = turnoRepository.save(turno);
        return mapper.convertValue(turno1, TurnoDto.class);
    }

    @Override
    public TurnoDto buscarPorId(Integer id) throws IllegalAccessException {
        LOGGER.debug("inicio buscarPorId");
        Optional<Turno> turno = turnoRepository.findById(id);
        if (turno.isPresent()) {
            LOGGER.debug("turno encontrado");
            return mapper.convertValue(turno.get(), TurnoDto.class);
        } else {
            throw new IllegalAccessException("El turno no existe");
        }
    }

        @Override
        public TurnoDto modificar (Turno turno){
            LOGGER.debug("el turno se modifico correctamente");
            Turno turnoNuevo = turnoRepository.save(turno);
            return mapper.convertValue(turnoNuevo, TurnoDto.class);
        }

    @Override
    public String eliminar(Integer id) throws IllegalAccessException {
        Optional<Turno> turnoEliminar = turnoRepository.findById(id);
        if(turnoEliminar.isPresent()) {
            turnoRepository.deleteById(id);
            LOGGER.debug("se elimino el id solicitado");
            return "El Turno se elimino correctamente";
        }
        throw new IllegalAccessException("El turno no existe");
    }


    @Override
    public List<TurnoDto> listar() {
        LOGGER.debug("inicio de listado de turnos");
        List<Turno> listaEntidades = turnoRepository.findAll();
        List<TurnoDto> listaPacientesDto = listaEntidades
                .stream()
                .map(turno -> mapper.convertValue(turno, TurnoDto.class))
                .collect(Collectors.toList());
        LOGGER.debug("se listaron correctamente los turnos");
        return listaPacientesDto;
    }

}




