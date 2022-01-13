package com.runt.olimpo.delegate;

import com.runt.olimpo.delegateImpl.IEstudianteDelegate;
import com.runt.olimpo.delegateImpl.IProfesorDelegate;
import com.runt.olimpo.dto.EstudianteDto;
import com.runt.olimpo.dto.ProfesorDto;
import com.runt.olimpo.exceptions.ServiceException;
import com.runt.olimpo.service.EstudianteService;
import com.runt.olimpo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteDelegate implements IEstudianteDelegate {

    final EstudianteService estudianteService;

    @Autowired
    public EstudianteDelegate(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @Override
    public List<EstudianteDto> consultarEstudiantes() throws ServiceException {
        return estudianteService.consultarEstudiantes();
    }
}
