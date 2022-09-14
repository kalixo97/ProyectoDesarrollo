package com.proyectoDesarrollo.Entities;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="email")
    private String email;
    @Column(name = "rol")
    //private String rol;
    private Enum_RoleName rol;
    @Transient
    private Profile perfil;
    //@OneToMany
    //@JoinColumn(name = "empresa")
    @Transient
    private Empresa empresa;
    //@Transient
    @ManyToOne
    @JoinColumn(name = "transaccion")
    private MovimientoDinero[] transaccion; //en forma de array

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Enum_RoleName getRol() {
        return rol;
    }

    public void setRol(Enum_RoleName rol) {
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
