package com.example.dao;
//En esta interface se utiliza la dependencia JPA

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Estudiante;

@Repository //Con la nueva versión no haría falta poner Repository -Se genera los beans automáticamente, no hace falta el beans.xml
public interface EstudianteDao extends JpaRepository<Estudiante, Integer> {
    
}
