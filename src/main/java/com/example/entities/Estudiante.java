package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Estudiante implements Serializable{
    private static final long serialVersionUID = 1L;

    // Las tablas deben tener un id, autoincremenetal y se debe poner con @
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincremental

    private int id;
    @NotNull(message = "El nombre no puede ser Null")
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private LocalDate fechaAlta;
    private LocalDate fechaNacimiento;
    private Genero genero;
    private double beca;
    //private int idFacultad; No haría falta ponerlo porque en @JoinColumn se crearía sólo

    //Relación entre tablas
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idFacultad")
    private Facultad facultad;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "estudiante")
    private List<Telefono> telefonos;


    public enum Genero {
        HOMBRE, MUJER, OTRO
    }



    
}
