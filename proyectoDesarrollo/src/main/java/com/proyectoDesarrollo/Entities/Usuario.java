package com.proyectoDesarrollo.Entities;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="email")
    private String email;
    @Column(name = "rol")
    private String rol;
    @Transient
    private Profile perfil;
    @Transient
    private Empresa empresa;
    @Transient
    private MovimientoDinero[] transaccion; //en forma de array

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getPerfil() {
        return perfil;
    }

    public void setPerfil(Profile perfil) {
        this.perfil = perfil;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public MovimientoDinero[] getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(MovimientoDinero[] transaccion) {
        this.transaccion = transaccion;
    }
}
