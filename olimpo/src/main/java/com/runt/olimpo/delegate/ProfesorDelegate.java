package com.runt.olimpo.delegate;

import com.runt.olimpo.delegateImpl.IProfesorDelegate;
import com.runt.olimpo.dto.AsignaturaDto;
import com.runt.olimpo.dto.ProfesorDto;
import com.runt.olimpo.exceptions.ServiceException;
import com.runt.olimpo.service.AsignaturaService;
import com.runt.olimpo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorDelegate implements IProfesorDelegate {

    final ProfesorService profesorService;

    final AsignaturaService asignaturaService;

    @Autowired
    public ProfesorDelegate(ProfesorService profesorService, AsignaturaService asignaturaService) {
        this.profesorService = profesorService;
        this.asignaturaService = asignaturaService;
    }

    @Override
    public List<ProfesorDto> consultarProfesores() throws ServiceException {
        List<ProfesorDto> profesores = profesorService.consultarProfesores();
        List<ProfesorDto> profesoresAsi = new ArrayList<>();
        profesores.forEach(i -> {
            try {
                List<AsignaturaDto> asignaturaDtos = asignaturaService.consultarAsignaturasIdProfesor(i.getId());
                if (!asignaturaDtos.isEmpty())
                    i.setProfesoresAr(asignaturaDtos);
                profesoresAsi.add(i);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });

        return profesoresAsi;
    }
}
