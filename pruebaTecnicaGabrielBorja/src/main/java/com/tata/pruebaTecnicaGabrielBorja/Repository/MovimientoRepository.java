package com.tata.pruebaTecnicaGabrielBorja.Repository;

import com.tata.pruebaTecnicaGabrielBorja.Model.Cuenta;
import com.tata.pruebaTecnicaGabrielBorja.Model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

}


