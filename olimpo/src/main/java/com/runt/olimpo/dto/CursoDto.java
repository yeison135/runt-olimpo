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
public class CursoDto implements Serializable {

    private Long id;

    private Integer grado;

    private String salon;

    @JsonManagedReference
    private ColegioDto colegio;

    @JsonBackReference
    private List<AsignaturaDto> asignaturas;
}
