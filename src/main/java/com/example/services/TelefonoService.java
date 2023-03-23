package com.example.services;

import java.util.List;

import com.example.entities.Estudiante;
import com.example.entities.Telefono;

public interface TelefonoService {
    public List<Telefono> findAll(); //Busca todo
    public Telefono findById(int idTelefono); //Busca por Id
    public void deleteById(int idTelefono); //Borra
    public void save (Telefono telefono); //Guarda y actualiza
    public void deleteByEstudiante (Estudiante estudiante);
    public List<Telefono> findByEstudiante(Estudiante estudiante);

}
