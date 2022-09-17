package com.proyectoDesarrollo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Perfil")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "telefono")
    private String telefono;

    //@OneToOne
    //@JoinColumn(name = "usuario")
    @Transient
    private Usuario usuario;

    public PerfilUsuario(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String phone) {
        this.telefono = phone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
