package com.runt.olimpo.service;

import com.runt.olimpo.dto.ProfesorDto;
import com.runt.olimpo.entities.Profesor;
import com.runt.olimpo.exceptions.ServiceException;
import com.runt.olimpo.repository.ProfesorRepository;
import com.runt.olimpo.serviceImpl.IProfesorService;
import com.runt.olimpo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService implements IProfesorService {

    final
    ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<ProfesorDto> consultarProfesores() throws ServiceException {
        List<Profesor> profesores = profesorRepository.findAll();
        if (profesores.isEmpty())
            throw new ServiceException("No hay registros creados para esta consulta");
        return ObjectMapperUtils.mapAll(profesores, ProfesorDto.class);
    }
}
