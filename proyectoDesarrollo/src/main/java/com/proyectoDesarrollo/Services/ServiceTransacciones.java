package com.proyectoDesarrollo.Services;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.MovimientoDinero;
import com.proyectoDesarrollo.Repository.IEmpresaRepository;
import com.proyectoDesarrollo.Repository.ITransaccionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServiceTransacciones {

    private ITransaccionRepository tranRepository;
    private IEmpresaRepository empresaRepository;


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

    public MovimientoDinero selectTranById(long Id){
        Optional<MovimientoDinero> existe = this.tranRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else{return null;}

    }

    public ArrayList<MovimientoDinero> selectTranByEmpId(int id) {

        return this.tranRepository.findbyEmpresaID(id);
    }
}
