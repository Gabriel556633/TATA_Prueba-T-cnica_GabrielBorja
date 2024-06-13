package com.tata.pruebaTecnicaGabrielBorja.Repository;

import com.tata.pruebaTecnicaGabrielBorja.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}


