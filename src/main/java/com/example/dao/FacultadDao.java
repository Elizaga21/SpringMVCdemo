package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Facultad;

@Repository
public interface FacultadDao extends JpaRepository<Facultad,Integer> {
    
}
