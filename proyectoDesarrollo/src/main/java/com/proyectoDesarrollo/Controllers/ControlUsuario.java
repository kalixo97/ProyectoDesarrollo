package com.proyectoDesarrollo.Controllers;

import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Services.Response;
import com.proyectoDesarrollo.Services.ServiceUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ControlUsuario {

    private ServiceUsuario userServicio;

    //Con ese constructor no se inicializa, eso lo hace el framework directamente,
    //solo se indica que dependencias se inyectan para que inicialice el servicio.
    //si se necesitan inicializar mas servicios, se ponene dentro de los parametros de entrada.
    public ControlUsuario(ServiceUsuario servicio){
        this.userServicio = servicio;
    }

    @RequestMapping("/")
    public String inicio(){
        return "Pagina de inicio";
    }

    @RequestMapping("/getusuarios")
    public ArrayList<Usuario> getUsuarios(){
        return this.userServicio.selectAll();
    }

    // Post es para REGISTRAR. No se ven en la visual la informacion en el navegador.
    // Metodo que permitira el recurso para registrar un usuario.
    // Metodo recibe Usuario para dar la respuesta a traves del metodo de crear Usuario
    // del Servicio.
    // EL RequestBody identifica que lo que ingresa al controlador está en formato json
    @PostMapping("create")
    public Response createUser(@RequestBody Usuario request){

        return this.userServicio.createUser(request);

    }
}
