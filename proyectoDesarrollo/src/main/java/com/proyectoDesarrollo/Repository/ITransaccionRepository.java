package com.proyectoDesarrollo.Repository;


import com.proyectoDesarrollo.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ITransaccionRepository extends JpaRepository<MovimientoDinero,Long> {
    //@Query("SELECT t FROM MovimientoDinero t WHERE t.empresa_id = ?1")
    //ArrayList<MovimientoDinero> findbyEmpresaID(int id);

    @Query("SELECT t FROM MovimientoDinero t WHERE t.empresa = ?1")
    ArrayList<MovimientoDinero> findbyEmpresaID(int monto);


}
