package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.EstudianteDao;
import com.example.entities.Estudiante;

@Service //Para la comunicacion entre Dao y Controller se necesita el Service

public class EstudianteServiceImpl implements EstudianteService {

    //Se necesita una dependencia del DAO
    @Autowired //Cuando haga falta la implementacion del estudiante se crea el objeto estudianteDao
    private EstudianteDao estudianteDao;

    @Override
    public List<Estudiante> findAll() {
        return estudianteDao.findAll();
    }

    @Override
    public Estudiante findById(int idEstudiante) {
        return estudianteDao.findById(idEstudiante).get();
    }

    @Override
    @Transactional
    public void deleteById(int idEstudiante) {
        // TODO Auto-generated method stub
        estudianteDao.deleteById(idEstudiante);
    } 

    @Override
    @Transactional
    public void save(Estudiante estudiante) {
    estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }
   
}

