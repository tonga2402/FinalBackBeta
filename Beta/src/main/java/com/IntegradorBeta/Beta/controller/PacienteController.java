package com.IntegradorBeta.Beta.controller;

import com.IntegradorBeta.Beta.dto.OdontologoDto;
import com.IntegradorBeta.Beta.dto.PacienteDto;
import com.IntegradorBeta.Beta.entity.Odontologo;
import com.IntegradorBeta.Beta.entity.Paciente;
import com.IntegradorBeta.Beta.exceptions.BadRequestException;
import com.IntegradorBeta.Beta.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDto> agregar (@RequestBody Paciente paciente) throws BadRequestException {
        return ResponseEntity.ok(pacienteService.agregar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPorId (@PathVariable Integer id) throws IllegalAccessException {
        PacienteDto pacienteDto = pacienteService.buscarPorId(id);

        if(pacienteDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(pacienteDto);
        }else {
            ResponseEntity<PacienteDto> response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return response;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) throws IllegalAccessException {
        if (id != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pacienteService.eliminar(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el Paciente");
        }
    }

    @PutMapping
    public ResponseEntity<PacienteDto> modificar (@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.modificar(paciente));
    }

    @GetMapping
    public List<PacienteDto> listar(){
        return pacienteService.listar();
    }
}
