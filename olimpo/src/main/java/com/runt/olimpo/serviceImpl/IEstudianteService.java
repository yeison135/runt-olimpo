package com.runt.olimpo.serviceImpl;

import com.runt.olimpo.dto.EstudianteDto;
import com.runt.olimpo.dto.ProfesorDto;
import com.runt.olimpo.exceptions.ServiceException;

import java.util.List;

public interface IEstudianteService {

    List<EstudianteDto> consultarEstudiantes() throws ServiceException;

}
