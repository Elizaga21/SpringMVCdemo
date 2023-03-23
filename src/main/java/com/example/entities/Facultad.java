package com.example.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Comentario en JavaDoc para documentar el proyecto
 * @author ElisabetAG
 */

@Entity
@Table(name = "facultades")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Facultad  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombre;

    //Relación entre tablas. MappedBy realiza una relacion bidireccional

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "facultad" ) //Atributo de Estudiante
    private List<Estudiante> estudiantes;
    
}
