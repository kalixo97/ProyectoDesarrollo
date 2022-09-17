package com.proyectoDesarrollo.Repository;


import com.proyectoDesarrollo.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransaccionRepository extends JpaRepository<MovimientoDinero,Long> {

}
