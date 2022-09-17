package com.proyectoDesarrollo.Services;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.MovimientoDinero;
import com.proyectoDesarrollo.Repository.IEmpresaRepository;
import com.proyectoDesarrollo.Repository.ITransaccionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceTransacciones {

    private ITransaccionRepository tranRepository;

    public ServiceTransacciones(ITransaccionRepository rep){
        this.tranRepository = rep;
    }

    public ArrayList<MovimientoDinero> selectAll(){
        return (ArrayList<MovimientoDinero>) this.tranRepository.findAll();
    }
    public Response createMovimiento(MovimientoDinero transaccion){
        Response response = new Response();
        //Se va al repositorio para hacer uso del metodo existente save
        this.tranRepository.save(transaccion);
        //Configura el code con 200
        response.setCode(200);
        //Configura el mensaje de la respuesta.
        response.setMessage("Usuario registrado exitosamente");
        return response;
    }


}
