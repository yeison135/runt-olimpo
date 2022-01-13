package com.runt.olimpo.delegateImpl;

import com.runt.olimpo.dto.EstudianteDto;
import com.runt.olimpo.exceptions.ServiceException;

import java.util.List;

public interface IEstudianteDelegate {

    List<EstudianteDto> consultarEstudiantes() throws ServiceException;

}
