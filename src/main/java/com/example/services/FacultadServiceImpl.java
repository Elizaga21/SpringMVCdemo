package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FacultadDao;
import com.example.entities.Facultad;

@Service

public class FacultadServiceImpl implements FacultadService {

    @Autowired
    private FacultadDao facultadDao;

    @Override
    public List<Facultad> findAll() {
        // TODO Auto-generated method stub
        return facultadDao.findAll();
    }

    @Override
    public Facultad findById(int idFacultad) {
        // TODO Auto-generated method stub
        return facultadDao.findById(idFacultad).get();
    }

    @Override
    public void deleteById(int idFacultad) {
        // TODO Auto-generated method stub
        facultadDao.deleteById(idFacultad);
    }

    @Override
    public void save(Facultad facultad) {
        // TODO Auto-generated method stub
        facultadDao.save(facultad);
    }
    
}
