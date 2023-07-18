package com.IntegradorBeta.Beta.controller;

import com.IntegradorBeta.Beta.dto.PacienteDto;
import com.IntegradorBeta.Beta.dto.TurnoDto;
import com.IntegradorBeta.Beta.entity.Paciente;
import com.IntegradorBeta.Beta.entity.Turno;
import com.IntegradorBeta.Beta.exceptions.BadRequestException;
import com.IntegradorBeta.Beta.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<TurnoDto> guardar(@RequestBody Turno turno) throws BadRequestException {
        return ResponseEntity.ok(turnoService.agregar(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDto> buscarPorId (@PathVariable Integer id) throws IllegalAccessException {
        TurnoDto turnoDto = turnoService.buscarPorId(id);

        if(turnoDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(turnoDto);
        }else {
            ResponseEntity<TurnoDto> response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return response;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar (@PathVariable Integer id) throws IllegalAccessException {
        if (id != null) {
            return ResponseEntity.status(HttpStatus.OK).body(turnoService.eliminar(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el Turno");
        }
    }

    @PutMapping
    public ResponseEntity<TurnoDto> modificar (@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.modificar(turno));
    }

    @GetMapping
    public List<TurnoDto> listar(){
        return turnoService.listar();
    }
}



