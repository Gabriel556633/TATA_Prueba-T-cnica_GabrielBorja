package com.tata.pruebaTecnicaGabrielBorja.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    private Integer idMovimiento;
    private String fecha;
    private String tipoMovimiento;
    private Integer valor;
    private Integer saldo;
    //private String numeroCuenta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="numerocuenta", nullable=false)
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(Integer idMovimiento, String fecha, String tipoMovimiento, Integer valor, Integer saldo, Cuenta cuenta) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
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

    public Integer getSaldo(Integer saldo) {
        return this.saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Integer getSaldo() {
        return saldo;
    }
}
