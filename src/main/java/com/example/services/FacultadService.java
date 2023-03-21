package com.example.services;

import java.util.List;

import com.example.entities.Facultad;

public interface FacultadService {
    public List<Facultad> findAll(); //Busca todo
    public Facultad findById(int idFacultad); //Busca por Id
    public void deleteById(int idFacultad); //Borra
    public void save (Facultad facultad); //Guarda y actualiza
}
