package com.IntegradorBeta.Beta.service;

import com.IntegradorBeta.Beta.dto.OdontologoDto;
import com.IntegradorBeta.Beta.entity.Odontologo;
import com.IntegradorBeta.Beta.exceptions.BadRequestException;
import com.IntegradorBeta.Beta.repository.OdontologoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class OdontologoServiceTest {

    @InjectMocks
    OdontologoService odontologoService;

    @Mock
    OdontologoRepository odontologoRepository;



    @Test
    void buscar_odontologo_existente_por_id() throws IllegalAccessException {

        //ARRANGE
        Odontologo odontologo = new Odontologo(2,100,"gaston","balmaceda");
        when(odontologoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        //ACT
        OdontologoDto odontologoDto = odontologoService.buscarPorId(2);
        //ASSERT
        Assertions.assertEquals("gaston", odontologoDto.getNombre());
    }

    @Test
    void agregar_un_odontologo() throws BadRequestException {

        //ARRANGE
        Odontologo odontologo = new Odontologo(2,100,"gaston","balmaceda");
        when(odontologoRepository.save(any())).thenReturn(odontologo);
        //ACT
        OdontologoDto odontologoDto = odontologoService.agregar(odontologo);
        //ASSERT

        Assertions.assertEquals(100, odontologo.getMatricula());
    }

    @Test
    void  eliminar_un_odontologo() throws IllegalAccessException {

        //ARRANGE
        Odontologo odontologo = new Odontologo(1,100,"gaston","balmaceda");
        when(odontologoRepository.findById(any())).thenReturn(Optional.of(odontologo));
        //ACT
        String respuesta = odontologoService.eliminar(1);
        //ASSERT

        Assertions.assertEquals("El Odontologo se elimino correctamente", respuesta);
    }

}