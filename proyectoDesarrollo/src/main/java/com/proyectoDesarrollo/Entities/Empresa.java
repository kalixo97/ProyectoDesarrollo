package com.proyectoDesarrollo.Entities;


public class Empresa {

    private long id;
    private String name;
    private String document;
    private String phone;
    private String address;

    private Usuario[] usuario;              //array
    private MovimientoDinero[] transaccion; //array


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Usuario[] getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario[] usuario) {
        this.usuario = usuario;
    }

    public MovimientoDinero[] getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(MovimientoDinero[] transaccion) {
        this.transaccion = transaccion;
    }
}
