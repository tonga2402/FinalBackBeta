package com.IntegradorBeta.Beta.service;

import com.IntegradorBeta.Beta.dto.OdontologoDto;
import com.IntegradorBeta.Beta.entity.Odontologo;
import com.IntegradorBeta.Beta.exceptions.BadRequestException;
import com.IntegradorBeta.Beta.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements AppService <Odontologo , OdontologoDto> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoService.class);

    @Autowired
    private OdontologoRepository odontologoRepository;


    @Autowired
    ObjectMapper mapper;

    public OdontologoService(OdontologoRepository odontologoRepository, ObjectMapper mapper) {
        this.odontologoRepository = odontologoRepository;
        this.mapper = new ObjectMapper();
    }

    @Override
    public OdontologoDto agregar(Odontologo odontologo) throws BadRequestException {
        LOGGER.debug("inicio OdontologoDto agregar");

        if (odontologo.getMatricula() < 0) {
            throw new BadRequestException("code 05" , "El número de matrícula no puede ser negativo");
        }
        if (odontologo.getNombre() == null || odontologo.getApellido() == null) {
            throw new BadRequestException("code 06" , "Los campos no pueden ser nulos");
        }
        if (odontologo.getNombre().isEmpty() || odontologo.getApellido().isEmpty() ){
            throw new BadRequestException("code 07" , "Los campos no pueden estar vacios");
        }
        if (odontologo.getNombre().length() < 3 || odontologo.getApellido().length() <3) {
            throw new BadRequestException("code 08" , "Debe contener minimo 3 caracteres");
        }
        LOGGER.debug("Odontologo creado");
        Odontologo odontologoNuevo = odontologoRepository.save(odontologo);

        return mapper.convertValue(odontologoNuevo, OdontologoDto.class);
    }
    @Override
    public OdontologoDto buscarPorId(Integer id) throws IllegalAccessException {
        LOGGER.debug("inicio buscarPorId");
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isPresent()){
            LOGGER.debug("Odontologo encontrado");
            return mapper.convertValue(odontologo.get(), OdontologoDto.class);
        }else{
            throw new IllegalAccessException("El odontologo no existe");
        }
    }

    @Override
    public OdontologoDto modificar(Odontologo odontologo) {
        LOGGER.debug("el odontologo se modifico correctamente");
        Odontologo odontologoNuevo = odontologoRepository.save(odontologo);
        return mapper.convertValue(odontologoNuevo, OdontologoDto.class);
    }

    @Override
    public String eliminar(Integer id) throws IllegalAccessException {
        Optional<Odontologo> odontologoEliminar = odontologoRepository.findById(id);
        if(odontologoEliminar.isPresent()) {
            odontologoRepository.deleteById(id);
            LOGGER.debug("se elimino el Odontologo solicitado");
            return "El Odontologo se elimino correctamente";
        }
        throw new IllegalAccessException("El odontologo no existe");
    }

    @Override
    public List<OdontologoDto> listar() {
        LOGGER.debug("inicio de listado de Odontologo");
        List<Odontologo> listaOdontologos = odontologoRepository.findAll();
        List<OdontologoDto> listaOdontolosDto = listaOdontologos.stream()
                .map(odontologo -> mapper.convertValue(odontologo,OdontologoDto.class))
                .collect(Collectors.toList());
        LOGGER.debug("se listaron correctamente los Odontologos");
        return listaOdontolosDto;
    }
}
