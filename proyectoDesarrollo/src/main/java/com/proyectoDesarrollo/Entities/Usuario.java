package com.proyectoDesarrollo.Entities;

import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="email", unique = true)
    private String email;
    @Column(name = "rol")
    //private String rol;
    private Enum_RoleName rol;
    @OneToOne
    @JoinColumn(name = "perfilUser")
    private PerfilUsuario perfil;
    @Transient
    private List<MovimientoDinero> transaccion; //en forma de array
    @Transient
    private Empresa empresa;
    //@OneToMany
    //@JoinColumn(name = "empresa")
    //@ManyToOne
    //@JoinColumn(name = "transaccion")
    public Usuario(){}

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

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
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

    public List<MovimientoDinero> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(List<MovimientoDinero> transaccion) {
        this.transaccion = transaccion;
    }
}
