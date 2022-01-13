package com.runt.olimpo.serviceImpl;

import com.runt.olimpo.dto.ProfesorDto;
import com.runt.olimpo.exceptions.ServiceException;

import java.util.List;

public interface IProfesorService {

    List<ProfesorDto> consultarProfesores() throws ServiceException;

}
