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
@Table(name = "curso")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "grado")
    private Integer grado;

    @Column(name = "salon")
    private String salon;

    @ManyToOne
    @JoinColumn(name = "colegio", nullable = false, updatable = false)
    @JsonManagedReference
    private Colegio colegio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    @JsonBackReference
    private List<Asignatura> asignaturas;


}