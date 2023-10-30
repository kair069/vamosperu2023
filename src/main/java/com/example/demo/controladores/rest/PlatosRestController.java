package com.example.demo.controladores.rest;
import java.util.List;

import com.example.demo.modelo.Platos;

import com.example.demo.servicios.PlatosServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/rest/platos")
public class PlatosRestController {
    @Autowired
    private PlatosServicios servicio;
    
    @CrossOrigin(origins = "*")
    @RequestMapping("/listarTodo")
    public String listarPlatos (Model model) {

        List <Platos> listaPlatos = servicio.buscarTodo();
        System.out.println("LISTA DE PLATOS : " + listaPlatos);
        model.addAttribute("listaPlatos", listaPlatos);
        return "/moduloPlatos/listarTodo";
    }
    //@GetMapping
    /*
    @RequestMapping("/listarTodo")
    public String buscarTodo()	{
        List<Platos> listaClientes = servicio.buscarTodo();

        System.out.println("LISTA DE FUNCIONES : " + listaClientes);


        return "/moduloPlatos/listarTodo";

    }
    */
    // @GetMapping
    //public ResponseEntity<Object> buscarTodo()	{
    //    List<Platos> listaClientes = servicio.buscarTodo();

    //    System.out.println("LISTA DE FUNCIONES : " + listaClientes);

        //return  new ResponseEntity<>(listaClientes, HttpStatus.OK);
     //   return "/moduloPlatos/listarTodo";

    //}

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
        Platos funcion = servicio.buscarPorId(id);
        if (funcion == null)

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Funcion no encontrada,id porporcionado no es correcto");
        return new ResponseEntity<Object>(funcion, HttpStatus.OK);

    }



    //CONFIGURACION DEL POST OSEA DEL ENVIO
    /*
    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public  ResponseEntity <Object> crear (@RequestBody Platos funcion){

        servicio.crear(funcion);
        return new ResponseEntity<Object>("Funcion creada correctamente", HttpStatus.OK);

    }
    */
    @CrossOrigin(origins = "*")
    @RequestMapping("/nuevo")
    public String nuevaPelicula(Model model) {
        Platos platos = new Platos ();
        model.addAttribute("platos",platos);
        return "/moduloPlatos/nuevoPlato";
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value ="/guardar", method= RequestMethod.POST)
    public String crearPelicula(@ModelAttribute("platos") Platos platos) {
        servicio.crear(platos);
        return "redirect:/rest/platos/listarTodo";

    }
    
    //actualizar por ID --------------USANDO
    @CrossOrigin(origins = "*")
    @RequestMapping(value ="/actualizar/{id}")
    public ModelAndView editarPelicula(@PathVariable(name="id") int id) {
        ModelAndView mav = new ModelAndView("/moduloPlatos/editarPlato");
        Platos platos = servicio.buscarPorId(id);
        mav.addObject("platos",platos);
        return mav;
    }







        @CrossOrigin(origins = "*")
        @PutMapping (value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Platos funcion){

        servicio.actualizar(funcion);
        return new ResponseEntity<Object>("Funcion actualizada correctamente", HttpStatus.OK);


    }

    ///eliminado
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/eliminar/{id}")
    public String elimnarPelicula(@PathVariable(name="id") int id) {
        servicio.borrarPorId(id);
        return "redirect:/rest/platos/listarTodo";
    }


    @DeleteMapping(value = "/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Object> eliminar(@PathVariable("id") int id) {
        servicio.eliminarClientes(id);
        return new ResponseEntity<Object>("Funcion eliminada correctamente", HttpStatus.OK);
    }



}
