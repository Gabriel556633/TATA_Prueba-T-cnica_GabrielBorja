package com.tata.pruebaTecnicaGabrielBorja.Dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PersonaDto implements Serializable {



    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("genero")
    private String genero;
    @JsonProperty("edad")
    private String edad;
    @JsonProperty("identificacion")
    private String identificacion;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;

    public PersonaDto() {
    }

    public PersonaDto(Integer id, String nombre, String genero, String edad, String identificacion, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
