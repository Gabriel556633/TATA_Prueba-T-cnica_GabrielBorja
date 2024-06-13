package com.tata.pruebaTecnicaGabrielBorja.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CuentaDto implements Serializable {

    @JsonProperty("numerocuenta")
    private String numerocuenta;

    @JsonProperty("tipocuenta")
    private String tipocuenta;

    @JsonProperty("saldoInicial")
    private String saldoInicial;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("clienteid")
    private Integer clienteid;

    public CuentaDto() {
    }

    public CuentaDto(String numerocuenta, String tipocuenta, String saldoInicial, String estado, Integer clienteid) {
        this.numerocuenta = numerocuenta;
        this.tipocuenta = tipocuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.clienteid = clienteid;
    }

    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(String saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }
}
