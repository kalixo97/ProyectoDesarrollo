package com.proyectoDesarrollo.Services;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.MovimientoDinero;
import com.proyectoDesarrollo.Entities.Usuario;
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

    public Response updateMovById(long id, MovimientoDinero dato){

        Response response = new Response();
        if(id<=0){
            response.setCode(500);
            response.setMessage("Error, el Id del movimiento no es valido");
            return response;
        }
        MovimientoDinero existe = selectTranById(id);
        if(existe == null){
            response.setCode(500);
            response.setMessage("Error, el movimiento no existe en la base de datos");
            return response;
        }
        existe.setConcepto(dato.getConcepto());
        existe.setMonto(dato.getMonto());
        this.tranRepository.save(existe);
        response.setCode(200);
        response.setMessage("Usuario modificado exitosamente");

        return response;
    }

    public Response deleteTranById(long id){
        this.tranRepository.deleteById(id);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("El ususario ha sido eliminado exitosamente");

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

    public Response createMovimientoByIdEmp(int id,MovimientoDinero transaccion){
        Response response = new Response();

        if(id==transaccion.getEmpresa().getId()){
            this.tranRepository.save(transaccion);
            response.setCode(200);
            response.setMessage("Usuario registrado exitosamente");
            return response;
        }
        else{
            response.setCode(500);
            response.setMessage("Error, el movimiento no existe en la base de datos");

            return response;
        }


    }

}
