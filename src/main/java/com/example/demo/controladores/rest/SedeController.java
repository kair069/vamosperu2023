package com.example.demo.controladores.rest;
/*ANTIGUO
import java.util.List;

import com.example.demo.modelo.Sede;


import com.example.demo.servicios.SedeServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
*/
import java.util.List;

import com.example.demo.modelo.Sede;


import com.example.demo.servicios.SedeServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rest/sedew")
public class SedeController {



    @Autowired
    private SedeServicios servicio;

    @RequestMapping("/listarTodo")
    public String listarSedes (Model model) {

        List <Sede> listaSedes= servicio.buscarTodo();
        System.out.println("LISTA DE Sedes: " + listaSedes);
        model.addAttribute("listaSedes", listaSedes);
        return "/moduloSede/listarTodo";
    }

    @RequestMapping("/nuevo")
    public String nuevaSede(Model model) {
        Sede sede = new Sede();
        model.addAttribute("sede",sede);
        return "/moduloSede/nuevoSede";
    }

    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String crearSede(@ModelAttribute("sede") Sede sede) {
        servicio.crear(sede);
        return "redirect:/rest/sedew/listarTodo";

    }

    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editarSede(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/moduloSede/editarSede");
        Sede sede = servicio.buscarPorId(id);
        mav.addObject("sede",sede);
        return mav;
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String elimnarSede(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/rest/sedew/listarTodo";
    }














    /*OMISION DE LA ANTIGUA
    @Autowired
    private SedeServicios servicio;

    @GetMapping
    public ResponseEntity<Object> buscarTodo()	{
        List<Sede> listaClientes = servicio.buscarTodo();

        System.out.println("LISTA DE FUNCIONES : " + listaClientes);

        return  new ResponseEntity<>(listaClientes, HttpStatus.OK);

    }


    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
        Sede funcion = servicio.buscarPorId(id);
        if (funcion == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Funcion no encontrada,id porporcionado no es correcto");
        return new ResponseEntity<Object>(funcion, HttpStatus.OK);

    }


    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public  ResponseEntity <Object> crear (@RequestBody Sede funcion){

        servicio.crear(funcion);
        return new ResponseEntity<Object>("Funcion creada correctamente", HttpStatus.OK);

    }

    @PutMapping (value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Sede funcion){

        servicio.actualizar(funcion);
        return new ResponseEntity<Object>("Funcion actualizada correctamente", HttpStatus.OK);


    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
        servicio.eliminarClientes(id);
        return new ResponseEntity<Object>("Funcion eliminada correctamente", HttpStatus.OK);
    }
    */

}
