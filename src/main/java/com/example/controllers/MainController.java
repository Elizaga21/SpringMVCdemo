package com.example.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Estudiante;
import com.example.entities.Facultad;
import com.example.entities.Telefono;
import com.example.services.EstudianteService;
import com.example.services.FacultadService;
import com.example.services.TelefonoService;

/**
 * El Main Controller RESPONDE a una peticion concreta y la delega posteriormente en un metodo que
 * tiene en cuenta el verbo (GET,POST, PUT, DELETE,OPTION) del protocolo HTTP utilizado para realizar la peticion
 */

@Controller //El servlet sigue estando pero dentro del Dispatcher Servlet
@RequestMapping("/") //MainController responde las peticiones que se vayan recibiendo
public class MainController {

    private static final Logger LOG = Logger.getLogger("MainController");

    @Autowired //Inyectar dependencia
    private EstudianteService estudianteService; //Inyectar servicio estudiantes

    @Autowired
    private FacultadService facultadService; //Inyectar servicio de facultad

    @Autowired
    private TelefonoService telefonoService;

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

    /**
     * Método que recibe los datos procedentes de los controles del formulario
     * 
     */

     @PostMapping("/altaModificacionEstudiante")
    public String altaEstudiante (@ModelAttribute Estudiante estudiante ,
            @RequestParam(name = "numerosTelefonos") String telefonosRecibidos) { //en el parametro recibe el metodo ModelAttribute y el RequestParam para los tel

        LOG.info("Telefonos recibidos: " + telefonosRecibidos); 

        List<String> listadoNumerosTelefonos = null; //primero lo declaramos null inicialmente

        if(telefonosRecibidos != null) { //También se puede añadir required en el formulario 

        String[] arrayTelefonos = telefonosRecibidos.split("/"); 

        listadoNumerosTelefonos = Arrays.asList(arrayTelefonos);


    }
        
        estudianteService.save(estudiante);

        if (listadoNumerosTelefonos != null) { //se crea un tlf y se guarda un teléfono (flujo telefonos)
            listadoNumerosTelefonos.stream().forEach(n -> { 
                Telefono telefonoObject = Telefono
            .builder()
            .numero(n)
            .estudiante(estudiante)
            .build();

            telefonoService.save(telefonoObject); //Añade los telefonos a la Base de Datos MySQL
        });

        }

          return "redirect:/listar"; 
          // return new RedirectView("/listar"); con este método se utiliza un RedirectView en public RedirectView altaEstudiante

    }
 /**
  * Actualiza un estudiante,antes se debe añadir en listarEstudiantes.html
  * Muestra el formulario para actualizar un estudiante
  */

  @GetMapping("/frmActualizar/{id}")
  public String frmActualizarEstudiante(@PathVariable(name = "id") int idEstudiante, Model model) { //para extraer la variable en la ruta se utiliza @PathVariable
 // Model son los datos del estudiante y se debe poner como parametro

   Estudiante estudiante = estudianteService.findById(idEstudiante);
   List<Telefono> todosTelefonos = telefonoService.findAll();
   //Recibe el telefono y lo pasa por el flujo pidiendo el id del estudiante creando una coleccion/lista
   List<Telefono> telefonosDelEstudiante = todosTelefonos.stream().filter
   (telefono -> telefono.getEstudiante().getId() == idEstudiante)
   .collect(Collectors.toList());

   //Model se utiliza para rellenar el formulario con datos
   model.addAttribute("estudiantes", estudiante);
   model.addAttribute("telefonos", telefonosDelEstudiante);

 

    return "views/formularioAltaEstudiante";
  }
}

