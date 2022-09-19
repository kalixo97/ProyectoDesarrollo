package com.proyectoDesarrollo.Controllers;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.MovimientoDinero;
import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Services.Response;
import com.proyectoDesarrollo.Services.ServiceEmpresa;;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
//@RequestMapping("index")
public class ControlEmpresa {
    private ServiceEmpresa empresaServicio;

    //Con ese constructor no se inicializa, eso lo hace el framework directamente,
    //solo se indica que dependencias se inyectan para que inicialice el servicio.
    //si se necesitan inicializar mas servicios, se ponene dentro de los parametros de entrada.
    public ControlEmpresa(ServiceEmpresa servicio){
        this.empresaServicio = servicio;
    }

    @RequestMapping("enterprises")
    public ArrayList<Empresa> getEmpresas(){

        return this.empresaServicio.selectAll();
    }

    // Post es para REGISTRAR. No se ven en la visual la informacion en el navegador.
    // Metodo que permitira el recurso para registrar un usuario.
    // Metodo recibe Usuario para dar la respuesta a traves del metodo de crear Usuario
    // del Servicio.
    // EL RequestBody identifica que lo que ingresa al controlador está en formato json
    @PostMapping("enterprises")
    public Response createEmpresa(@RequestBody Empresa request){

        return this.empresaServicio.createEmpresa(request);

    }

    //ruta relativa
    @RequestMapping("enterprise/{id}")
    public Empresa getEmpresaById(@PathVariable int id){

        return this.empresaServicio.selectEmpresatById(id);
    }

    @DeleteMapping("enterprise/{id}")
    public Response deleteEmpresa(@PathVariable int id){
        return this.empresaServicio.deleteEmpresaById(id);
    }

    //HASTA ACA SE TIENE QUE ENVIAR UN ID EN EL POSRTMAN

    @PatchMapping("enterprise/{id}")
    public Response updateEmpresaById(@PathVariable int id, @RequestBody Empresa request){


        return this.empresaServicio.updateEmpresaById(id, request);

    }

}
