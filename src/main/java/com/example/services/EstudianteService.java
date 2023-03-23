package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;

public interface EstudianteService {
    public List<Estudiante> findAll(); //Busca todo
    public Estudiante findById(int idEstudiante); //Busca por Id
    public void deleteById(int idEstudiante); //Borra
    public void save (Estudiante estudiante); //Guarda y actualiza
    public void delete (Estudiante estudiante); // Borrar
    
    /**
     * No es necesario un método UPDATE porque el save inserta o actualiza, en dependencia de que el idEstudiante exista 
     * o no, es decir, si no existe lo crea, y si existe actualiza la información
     */
}
