package com.runt.olimpo.delegateImpl;

import com.runt.olimpo.dto.AsignaturaDto;
import com.runt.olimpo.exceptions.ServiceException;

import java.util.List;

public interface IAsignaturaDelegate {

    List<AsignaturaDto> consultarAsignaturas() throws ServiceException;

}
