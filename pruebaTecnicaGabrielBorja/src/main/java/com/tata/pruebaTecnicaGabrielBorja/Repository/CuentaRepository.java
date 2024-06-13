package com.tata.pruebaTecnicaGabrielBorja.Repository;

import com.tata.pruebaTecnicaGabrielBorja.Model.Cliente;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, String> {

}


