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

    @DeleteMapping ("movements/{id}")
    public Response deleteUsuario(@PathVariable long id){
        return this.servMovEmp.deleteTranById(id);
    }
    /*@GetMapping("enterprises/{id}/movements")
    public ArrayList<MovimientoDinero> getTranById(@PathVariable int id){

        Empresa empresa = new Empresa();
        empresa= this.serviceEmpresa.selectEmpresatById(id);

        return this.servMovEmp.selectTranByEmpId(empresa.getId());
    }*/

    @PatchMapping("movement/{id}")
    public Response updateMovimientoById(@PathVariable int id, @RequestBody MovimientoDinero request){

        return this.servMovEmp.updateMovById(id, request);

    }

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

    @DeleteMapping("enterprises/{id}/movements")

    public Response deleteMovById(@PathVariable int id){

        ArrayList<MovimientoDinero> transacciones= new ArrayList<>();
        transacciones = this.serviceEmpresa.MovById(id);
        Response response = new Response();

        for(int i=0;i<transacciones.size();i++){
             response=this.servMovEmp.deleteTranById((transacciones.get(i).getId()));
        }
        return response;
        //servMovEmp.deleteTranById(id);

    }

    @PatchMapping("enterprises/{id1}/movement/{id2}")
    public Response updateMovByIdEMp(@PathVariable int id1, @PathVariable long id2,
                                     @RequestBody MovimientoDinero request){
        ArrayList<MovimientoDinero> transacciones= new ArrayList<>();
        transacciones = this.serviceEmpresa.MovById(id1);
        Response response = new Response();
        boolean esid=false;

        for(int i=0;i<transacciones.size();i++){
            if (transacciones.get(i).getId()==id2){
                esid=true;
                break;
            }
        }
        if(esid=true){
            return this.servMovEmp.updateMovById(id2, request);
        }
        else {
            response.setCode(500);
            response.setMessage("Error, no se esta vinculando la empresa indicada");
            return response;
        }
    }

    @PostMapping("enterprises/{id}/movements")
    public Response createTranByIdEmp(@PathVariable int id, @RequestBody MovimientoDinero transaccion){

        return this.servMovEmp.createMovimientoByIdEmp(id, transaccion);

    }

}
