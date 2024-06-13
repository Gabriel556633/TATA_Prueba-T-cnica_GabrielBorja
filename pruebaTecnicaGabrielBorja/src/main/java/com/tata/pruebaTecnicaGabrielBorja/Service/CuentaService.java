package com.tata.pruebaTecnicaGabrielBorja.Service;

import com.tata.pruebaTecnicaGabrielBorja.Dto.ClienteDto;
import com.tata.pruebaTecnicaGabrielBorja.Dto.CuentaDto;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cliente;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cuenta;
import com.tata.pruebaTecnicaGabrielBorja.Repository.ClienteRepository;
import com.tata.pruebaTecnicaGabrielBorja.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CuentaService {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CuentaRepository cuentaRepository;
    public List<CuentaDto> getAllCuentas(){
        List<CuentaDto> response = new ArrayList<CuentaDto>();
        List<Cuenta> result = this.cuentaRepository.findAll();
        for(int i=0;i<result.size();i++){
            CuentaDto cuentaDto = new CuentaDto();
            cuentaDto.setNumerocuenta(result.get(i).getNumerocuenta());
            cuentaDto.setClienteid(result.get(i).getCliente().getClienteid());
            cuentaDto.setTipocuenta(result.get(i).getTipocuenta());
            cuentaDto.setSaldoInicial(result.get(i).getSaldoInicial());
            cuentaDto.setEstado(result.get(i).getEstado());
            response.add(cuentaDto);
        }
        System.out.println(response.toString());
        return response;
    }

    public CuentaDto getbyId(String Id){
        CuentaDto cuentaDto = new CuentaDto();
    try{
        Cuenta result = this.cuentaRepository.getReferenceById(Id);
        cuentaDto.setNumerocuenta(result.getNumerocuenta());
        cuentaDto.setClienteid(result.getCliente().getClienteid());
        cuentaDto.setTipocuenta(result.getTipocuenta());
        cuentaDto.setSaldoInicial(result.getSaldoInicial());
        cuentaDto.setEstado(result.getEstado());

    }catch (Exception e){
        cuentaDto.setNumerocuenta("NO EXISTE ESE NUMERO DE CUENTA");
    }
        return cuentaDto;
    }

    public Cuenta saveCuentas(CuentaDto cuentaDto) {
        Cuenta c =  new Cuenta();
        ClienteDto clienteDto = clienteService.getbyId(cuentaDto.getClienteid());
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setClienteid(clienteDto.getClienteid());
        cliente.setContraseña(clienteDto.getContraseña());
        cliente.setDireccion(clienteDto.getdireccion());
        cliente.setEdad(clienteDto.getEdad());
        cliente.setEstado(clienteDto.getEstado());
        cliente.setGenero(clienteDto.getGenero());
        cliente.setIdentificacion(clienteDto.getIdentificacion());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setTelefono(clienteDto.getTelefono());


        c.setCliente(cliente);
        c.setTipocuenta(cuentaDto.getTipocuenta());
        c.setSaldoInicial(cuentaDto.getSaldoInicial());
        c.setEstado(cuentaDto.getEstado());
        c.setNumerocuenta(cuentaDto.getNumerocuenta());

        this.cuentaRepository.save(c);


        return c;
    }

    public Boolean deleteCuenta(String id) {
        this.cuentaRepository.deleteById(id);
        return true;
    }
    
}