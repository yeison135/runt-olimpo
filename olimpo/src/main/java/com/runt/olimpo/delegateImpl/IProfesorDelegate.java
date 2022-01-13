package com.runt.olimpo.delegateImpl;

import com.runt.olimpo.dto.ProfesorDto;
import com.runt.olimpo.exceptions.ServiceException;

import java.util.List;

public interface IProfesorDelegate {

    List<ProfesorDto> consultarProfesores() throws ServiceException;

}
