package com.runt.olimpo.service;

import com.runt.olimpo.dto.EstudianteDto;
import com.runt.olimpo.entities.Estudiante;
import com.runt.olimpo.exceptions.ServiceException;
import com.runt.olimpo.repository.EstudianteRepository;
import com.runt.olimpo.serviceImpl.IEstudianteService;
import com.runt.olimpo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService implements IEstudianteService {

    final
    EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<EstudianteDto> consultarEstudiantes() throws ServiceException {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        if (estudiantes.isEmpty())
            throw new ServiceException("No hay registros creados para esta consulta");
        return ObjectMapperUtils.mapAll(estudiantes, EstudianteDto.class);
    }
}
