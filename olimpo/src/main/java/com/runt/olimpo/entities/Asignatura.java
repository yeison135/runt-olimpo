package com.runt.olimpo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "asignatura")
@Data
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "curso", nullable = false, updatable = false)
    @JsonManagedReference
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "profesor", nullable = false, updatable = false)
    @JsonManagedReference
    private Profesor profesor;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Estudiante> estudiantes;

}