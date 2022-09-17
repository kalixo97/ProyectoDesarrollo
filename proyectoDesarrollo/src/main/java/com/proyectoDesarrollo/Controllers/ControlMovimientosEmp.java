package com.proyectoDesarrollo.Controllers;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.MovimientoDinero;
import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Services.Response;
import com.proyectoDesarrollo.Services.ServiceEmpresa;
import com.proyectoDesarrollo.Services.ServiceTransacciones;
import com.proyectoDesarrollo.Services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transaction;
import java.net.URI;
import java.util.ArrayList;

@RestController
public class ControlMovimientosEmp {

    @Autowired
    ServiceEmpresa serviceEmpresa;

    @Autowired
    ServiceTransacciones servMovEmp;

    public ControlMovimientosEmp(ServiceTransacciones servicio){
        this.servMovEmp = servicio;
    }

    @RequestMapping("movements")
    public ArrayList<MovimientoDinero> getTransacciones(){

        return this.servMovEmp.selectAll();
    }

    @PostMapping("movements")
    public Response createMovimiento(@RequestBody MovimientoDinero transaccion){

        return this.servMovEmp.createMovimiento(transaccion);

    }

    /*@GetMapping("enterprises/{id}/movements")
    public ArrayList<MovimientoDinero> getTranById(@PathVariable int id){

        Empresa empresa = new Empresa();
        empresa= this.serviceEmpresa.selectEmpresatById(id);

        return this.servMovEmp.selectTranByEmpId(empresa.getId());
    }*/

    @GetMapping("enterprisesmov/{id}")
    public ArrayList<MovimientoDinero> getTranById(@PathVariable int id){


        return this.servMovEmp.selectTranByEmpId(id);
    }

    @GetMapping("enterprisesnom/{id}")
    public ArrayList<String> getNombreById(@PathVariable int id){


        return this.serviceEmpresa.NombreById(id);
    }

    @GetMapping("enterprises/{id}/movements")

    public ArrayList<MovimientoDinero> getMovById(@PathVariable int id){

        return this.serviceEmpresa.MovById(id);
    }

}
