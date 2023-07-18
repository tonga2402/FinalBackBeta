package com.IntegradorBeta.Beta.service;

import com.IntegradorBeta.Beta.dto.OdontologoDto;
import com.IntegradorBeta.Beta.dto.PacienteDto;
import com.IntegradorBeta.Beta.entity.Odontologo;
import com.IntegradorBeta.Beta.entity.Paciente;
import com.IntegradorBeta.Beta.exceptions.BadRequestException;
import com.IntegradorBeta.Beta.repository.OdontologoRepository;
import com.IntegradorBeta.Beta.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService implements AppService <Paciente , PacienteDto> {

    private static final Logger LOGGER = Logger.getLogger(PacienteService.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public PacienteDto agregar(Paciente paciente) throws BadRequestException {
        LOGGER.debug("inicio PacienteDto agregar");
        if(paciente.getDni() <= 0) {
            throw new BadRequestException("code 03","El DNI es incorrecto");
        }

        if(paciente.getDni().longValue() < 8) {
            throw new BadRequestException("code 04","El DNI debe contener al menos 8 digitos");
        }
        LOGGER.debug("Paciente creado");
        Paciente pacienteNuevo = pacienteRepository.save(paciente);
        return mapper.convertValue(pacienteNuevo, PacienteDto.class);
    }

    @Override
    public PacienteDto buscarPorId(Integer id) throws IllegalAccessException {
        LOGGER.debug("inicio buscarPorId");
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isPresent()){
            LOGGER.debug("Paciente encontrado");
            return mapper.convertValue(paciente.get(), PacienteDto.class);
        }
            throw new IllegalAccessException("El paciente no existe");

    }


    @Override
    public PacienteDto modificar(Paciente paciente) {
        LOGGER.debug("el paciente se modifico correctamente");
        Paciente pacienteNuevo = pacienteRepository.save(paciente);
        return mapper.convertValue(pacienteNuevo, PacienteDto.class);
    }


    @Override
    public String eliminar(Integer id) throws IllegalAccessException {
        Optional<Paciente> pacienteEliminar = pacienteRepository.findById(id);
        if(pacienteEliminar.isPresent()) {
            pacienteRepository.deleteById(id);
            LOGGER.debug("se elimino el Paciente solicitado");
            return "El Paciente se elimino correctamente";
        }
        throw new IllegalAccessException("El paciente no existe");
    }


    @Override
    public List<PacienteDto> listar() {
        LOGGER.debug("inicio de listado de Pacientes");
        List<Paciente> listaPaciente = pacienteRepository.findAll();
        List<PacienteDto> listaPacientesDto = listaPaciente.stream()
                .map(paciente -> mapper.convertValue(paciente,PacienteDto.class))
                .collect(Collectors.toList());
        LOGGER.debug("se listaron correctamente los pacientes");
        return listaPacientesDto;
    }
}
