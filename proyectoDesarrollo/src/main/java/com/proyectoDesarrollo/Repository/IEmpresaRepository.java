package com.proyectoDesarrollo.Repository;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa,Integer> {
    @Query("SELECT t.nombre FROM Empresa t WHERE t.id = ?1")
    ArrayList<String> findNombyEmpresaID(int id);

    @Query("SELECT t.transaccion FROM Empresa t WHERE t.id = ?1")
    ArrayList<MovimientoDinero> findMovbyEmpresaID(int id);


}
