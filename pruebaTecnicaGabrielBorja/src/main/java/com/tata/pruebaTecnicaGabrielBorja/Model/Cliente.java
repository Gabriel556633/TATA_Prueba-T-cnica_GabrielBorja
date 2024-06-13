package com.tata.pruebaTecnicaGabrielBorja.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tata.pruebaTecnicaGabrielBorja.Dto.ClienteDto;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    private Integer id;
    private String nombre;
    private String genero;
    private String edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private Integer clienteid;
    private String contraseña;
    private String estado;

    @OneToMany(mappedBy="cliente")
    private Set<Cuenta> cuentaSet;


    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String genero, String edad, String identificacion, String direccion, String telefono, Integer clienteid, String contraseña, String estado, Set<Cuenta> cuentaSet) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.clienteid = clienteid;
        this.contraseña = contraseña;
        this.estado = estado;
        this.cuentaSet = cuentaSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Cuenta> getCuentaSet() {
        return cuentaSet;
    }

    public void setCuentaSet(Set<Cuenta> cuentaSet) {
        this.cuentaSet = cuentaSet;
    }
}
