package com.proyectoDesarrollo.Services;

import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceUsuario {

    private IUsuarioRepository userRepository;

    public ServiceUsuario(IUsuarioRepository rep){
        this.userRepository = rep;
    }

    public ArrayList<Usuario> selectAll(){
        return (ArrayList<Usuario>) this.userRepository.findAll();
    }


    //Metodo que recibe un parametro de tipo Usuario y devolverá una Response
    public Response createUser(Usuario user){
        Response response = new Response();
        //Se va al repositorio para hacer uso del metodo existente save
        this.userRepository.save(user);
        //Configura el code con 200
        response.setCode(200);
        //Configura el mensaje de la respuesta.
        response.setMessage("Usuario registrado exitosamente");
        return response;
    }
}
