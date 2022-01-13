package com.runt.olimpo.delegate;

import com.runt.olimpo.delegateImpl.IAsignaturaDelegate;
import com.runt.olimpo.dto.AsignaturaDto;
import com.runt.olimpo.exceptions.ServiceException;
import com.runt.olimpo.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaDelegate implements IAsignaturaDelegate {

    final AsignaturaService asignaturaService;

    @Autowired
    public AsignaturaDelegate(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @Override
    public List<AsignaturaDto> consultarAsignaturas() throws ServiceException {
        return asignaturaService.consultarAsignaturas();
    }
}
