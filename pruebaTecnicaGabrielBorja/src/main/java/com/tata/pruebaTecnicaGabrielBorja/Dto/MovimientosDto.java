package com.tata.pruebaTecnicaGabrielBorja.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovimientosDto {

    @JsonProperty("idMovimiento")
    private Integer idMovimiento;

    @JsonProperty("fecha")
    private String fecha;

    @JsonProperty("tipoMovimiento")
    private String tipoMovimiento;

    @JsonProperty("valor")
    private Integer valor;

    @JsonProperty("saldo")
    private Integer saldo;

    @JsonProperty("numeroCuenta")
    private String numeroCuenta;

    public MovimientosDto() {
    }

    public MovimientosDto(Integer idMovimiento, String fecha, String tipoMovimiento, Integer valor, Integer saldo, String numeroCuenta) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public Integer getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Integer idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
