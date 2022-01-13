package com.runt.olimpo.controller;

import com.runt.olimpo.delegate.AsignaturaDelegate;
import com.runt.olimpo.delegate.EstudianteDelegate;
import com.runt.olimpo.delegate.ProfesorDelegate;
import com.runt.olimpo.dto.AsignaturaDto;
import com.runt.olimpo.dto.EstudianteDto;
import com.runt.olimpo.dto.ProfesorDto;
import com.runt.olimpo.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class OlimpoController {

    final AsignaturaDelegate asignaturaDelegate;

    final ProfesorDelegate profesorDelegate;

    final EstudianteDelegate estudianteDelegate;

    @Autowired
    public OlimpoController(AsignaturaDelegate asignaturaDelegate, ProfesorDelegate profesorDelegate, EstudianteDelegate estudianteDelegate) {
        this.asignaturaDelegate = asignaturaDelegate;
        this.profesorDelegate = profesorDelegate;
        this.estudianteDelegate = estudianteDelegate;
    }

    @GetMapping("/asignaturas")
    public ResponseEntity<List<AsignaturaDto>> consultarAsignaturas() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(asignaturaDelegate.consultarAsignaturas());
        } catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/profesores")
    public ResponseEntity<List<ProfesorDto>> consultarProfesores() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(profesorDelegate.consultarProfesores());
        } catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDto>> consultarEstudiantes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(estudianteDelegate.consultarEstudiantes());
        } catch (ServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
