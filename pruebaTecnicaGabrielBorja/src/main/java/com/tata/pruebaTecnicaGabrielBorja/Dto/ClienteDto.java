package com.tata.pruebaTecnicaGabrielBorja.Dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDto extends PersonaDto {
    @JsonProperty("clienteid")
    private Integer clienteid;
    @JsonProperty("contraseña")
    private String contraseña;
    @JsonProperty("estado")
    private String estado;

    public ClienteDto() {
    }

    public ClienteDto(Integer clienteid, String contraseña, String estado) {
        this.clienteid = clienteid;
        this.contraseña = contraseña;
        this.estado = estado;
    }

    public ClienteDto(Integer id, String nombre, String genero, String edad, String identificacion, String dirección, String telefono, Integer clienteid, String contraseña, String estado) {
        super(id, nombre, genero, edad, identificacion, dirección, telefono);
        this.clienteid = clienteid;
        this.contraseña = contraseña;
        this.estado = estado;
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
}
