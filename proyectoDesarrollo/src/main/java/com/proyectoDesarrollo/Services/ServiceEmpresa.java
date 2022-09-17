package com.proyectoDesarrollo.Services;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.MovimientoDinero;
import com.proyectoDesarrollo.Repository.IEmpresaRepository;
import com.proyectoDesarrollo.Repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServiceEmpresa {
    private IEmpresaRepository empresaRepository;

    public ServiceEmpresa(IEmpresaRepository rep){
        this.empresaRepository = rep;
    }

    //GET con POSTMAN
    public ArrayList<Empresa> selectAll(){
        return (ArrayList<Empresa>) this.empresaRepository.findAll();
    }

    //Metodo que recibe un parametro de tipo Usuario y devolverá una Response
    //POST con POSTMAN
    public Response createEmpresa(Empresa empresa){
        Response response = new Response();
        //Se va al repositorio para hacer uso del metodo existente save
        this.empresaRepository.save(empresa);
        //Configura el code con 200
        response.setCode(200);
        //Configura el mensaje de la respuesta.
        response.setMessage("Usuario registrado exitosamente");
        return response;
    }

    public Empresa selectEmpresatById(int Id){
        Optional<Empresa> existe = this.empresaRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else{return null;}

    }

    public Response deleteEmpresaById(int id){
        this.empresaRepository.deleteById(id);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("El ususario ha sido eliminado exitosamente");

        return response;
    }

    //public Response updateUsuario(int id){
    public Response updateEmpresa(Empresa dato){

        //Usuario dato =new Usuario();


        Response response = new Response();

        if(dato.getId() == 0){
            response.setCode(500);
            response.setMessage("Error, el Id del usuario no es valido");
            return response;
        }

        Empresa existe = selectEmpresatById(dato.getId());
        if(existe == null){
            response.setCode(500);
            response.setMessage("Error, el usuario no existe en la base de datos");
            return response;
        }

        existe.setNombre(dato.getNombre());
        this.empresaRepository.save(existe);
        response.setCode(200);
        response.setMessage("Usuario modificado exitosamente");

        return response;
    }

    public ArrayList<String> NombreById(int id){

        return this.empresaRepository.findNombyEmpresaID(id);
    }

    public ArrayList<MovimientoDinero> MovById(int id){

        return this.empresaRepository.findMovbyEmpresaID(id);
    }

}
