package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;

/**
 * El Main Controller RESPONDE a una peticion concreta y la delega posteriormente en un metodo que
 * tiene en cuenta el verbo (GET,POST, PUT, DELETE,OPTION) del protocolo HTTP utilizado para realizar la peticion
 */

@Controller //El servlet sigue estando pero dentro del Dispatcher Servlet
@RequestMapping("/") //MainController responde las peticiones que se vayan recibiendo
public class MainController {

    @Autowired //Inyectar dependencia
    private EstudianteService estudianteService; //Inyectar servicio estudiantes

    @Autowired
    private FacultadService facultadService; //Inyectar servicio de facultad

    /**
     * Este metodo devuelve un listado de estudiantes
     * Antes se debe crear una carpeta views dentro de templates y luego otro file con el nombre del metodo
     */
    @GetMapping("/listar")
    public ModelAndView listar() { // Este Método respondera concretamente a cada peticion

        List<Estudiante> estudiantes = estudianteService.findAll();


        ModelAndView mav = new ModelAndView("views/listarEstudiantes");
        mav.addObject("estudiantes", estudiantes);
        

        return mav;
    }

/*Muestra el formulario de alta de estudiante
 */    
    @GetMapping("/frmAltaEstudiante")
    public String formularioAltaEstudiante(Model model) {

        List<Facultad> facultades = facultadService.findAll(); //Se añade listado de facultades para el formulario

       model.addAttribute("estudiante", new Estudiante()); // esta vacio el parametro porque en el formulario se rellena
       model.addAttribute("facultades", facultades);

        return "views/formularioAltaEstudiante";
    }
}
