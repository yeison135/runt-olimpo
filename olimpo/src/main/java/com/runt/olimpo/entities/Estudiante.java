package com.runt.olimpo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "estudiante")
@Data
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JoinTable(
            name = "rel_estudiante_asignatura",
            joinColumns = @JoinColumn(name = "estudiante", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "asignatura", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Asignatura> asignaturas;

}