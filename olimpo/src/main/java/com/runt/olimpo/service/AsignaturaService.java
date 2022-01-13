package com.runt.olimpo.service;

import com.runt.olimpo.dto.AsignaturaDto;
import com.runt.olimpo.entities.Asignatura;
import com.runt.olimpo.entities.Profesor;
import com.runt.olimpo.exceptions.ServiceException;
import com.runt.olimpo.repository.AsignaturaRepository;
import com.runt.olimpo.serviceImpl.IAsignturaService;
import com.runt.olimpo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService implements IAsignturaService {

    final
    AsignaturaRepository asignaturaRepository;

    @Autowired
    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public List<AsignaturaDto> consultarAsignaturas() throws ServiceException {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        if (asignaturas.isEmpty())
            throw new ServiceException("No hay asignaturas creadas");
        return ObjectMapperUtils.mapAll(asignaturas, AsignaturaDto.class);
    }

    @Override
    public List<AsignaturaDto> consultarAsignaturasIdProfesor(Long id) throws ServiceException {
        Profesor profesor = new Profesor();
        profesor.setId(id);
        List<Asignatura> asignaturas = asignaturaRepository.findByProfesor(profesor);
        if (asignaturas.isEmpty())
            throw new ServiceException("No hay asignaturas creadas");
        return ObjectMapperUtils.mapAll(asignaturas, AsignaturaDto.class);
    }
}
