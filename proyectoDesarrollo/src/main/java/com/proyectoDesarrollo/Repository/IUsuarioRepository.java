package com.proyectoDesarrollo.Repository;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

}

