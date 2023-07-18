package com.IntegradorBeta.Beta.controller;

import com.IntegradorBeta.Beta.dto.OdontologoDto;
import com.IntegradorBeta.Beta.entity.Odontologo;
import com.IntegradorBeta.Beta.exceptions.BadRequestException;
import com.IntegradorBeta.Beta.service.OdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController  {

    @Autowired
    private OdontologoService odontologoService;


    @PostMapping
    public ResponseEntity<OdontologoDto> agregar (@RequestBody Odontologo odontologo) throws BadRequestException {
        return ResponseEntity.ok(odontologoService.agregar(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDto> buscarPorId (@PathVariable Integer id) throws IllegalAccessException {
        OdontologoDto odontologoDto = odontologoService.buscarPorId(id);

        if(odontologoDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(odontologoDto);
        }else {
            ResponseEntity<OdontologoDto> response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return response;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) throws IllegalAccessException {
        if (id != null) {
            return ResponseEntity.status(HttpStatus.OK).body(odontologoService.eliminar(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el Odontologo");
        }
    }

    @PutMapping
    public ResponseEntity<OdontologoDto> modificar (@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.modificar(odontologo));
    }

    @GetMapping
    public List<OdontologoDto> listar(){
        return odontologoService.listar();
    }








}
