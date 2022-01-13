package com.runt.olimpo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ProfesorDto implements Serializable {

    private Long id;

    private String nombre;

    @JsonBackReference
    private List<AsignaturaDto> profesores;

    private List<AsignaturaDto> profesoresAr;
}
