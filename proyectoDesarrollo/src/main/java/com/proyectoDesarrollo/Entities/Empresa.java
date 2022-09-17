package com.proyectoDesarrollo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "documento")
    private String documento;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;

    @Transient
    //@ManyToOne
    //@JoinColumn(name = "usuario")
    private List<Usuario> usuario;              //array

    //@JsonIgnore
    //Esta funcionaba segun el video
    //@OneToMany(mappedBy = "empresa")

    //@ManyToOne(cascade =CascadeType.ALL)
    //@JoinColumn(name = "transaccion_id", referencedColumnName = "id")

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<MovimientoDinero> transaccion = new HashSet<>();
    //private List<MovimientoDinero> transaccion = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String phone) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public Set<MovimientoDinero> getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Set<MovimientoDinero> transaccion) {
        this.transaccion = transaccion;
    }
}
