package com.tata.pruebaTecnicaGabrielBorja.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    private String numerocuenta;
    private String tipocuenta;
    private String saldoInicial;
    private String estado;
   // private Integer clienteid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clienteid", nullable=false)
    private Cliente cliente;
    @OneToMany(mappedBy="cuenta")
    private Set<Movimiento> movimientoSet;

    public Cuenta() {
    }

    public Cuenta(String numerocuenta, String tipocuenta, String saldoInicial, String estado, Cliente cliente, Set<Movimiento> movimientoSet) {
        this.numerocuenta = numerocuenta;
        this.tipocuenta = tipocuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.cliente = cliente;
        this.movimientoSet = movimientoSet;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Movimiento> getMovimientoSet() {
        return movimientoSet;
    }

    public void setMovimientoSet(Set<Movimiento> movimientoSet) {
        this.movimientoSet = movimientoSet;
    }
}
