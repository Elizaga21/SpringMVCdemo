package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TelefonoDao;
import com.example.entities.Telefono;

@Service

public class TelefonoServiceImpl implements TelefonoService {

    @Autowired 
    private TelefonoDao telefonoDao;

    @Override
    public List<Telefono> findAll() {
        // TODO Auto-generated method stub
        return telefonoDao.findAll();
    }

    @Override
    public Telefono findById(int idTelefono) {
        // TODO Auto-generated method stub
        return telefonoDao.findById(idTelefono).get();
    }

    @Override
    public void deleteById(int idTelefono) {
        // TODO Auto-generated method stub
        telefonoDao.deleteById(idTelefono);
    }

    @Override
    public void save(Telefono telefono) {
        // TODO Auto-generated method stub
        telefonoDao.save(telefono);
    }
    
}
