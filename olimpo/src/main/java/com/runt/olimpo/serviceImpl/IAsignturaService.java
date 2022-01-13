package com.runt.olimpo.serviceImpl;

import com.runt.olimpo.dto.AsignaturaDto;
import com.runt.olimpo.exceptions.ServiceException;

import java.util.List;

public interface IAsignturaService {

    List<AsignaturaDto> consultarAsignaturas() throws ServiceException;

    List<AsignaturaDto> consultarAsignaturasIdProfesor(Long id) throws ServiceException;

}
