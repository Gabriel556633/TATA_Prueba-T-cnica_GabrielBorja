package com.tata.pruebaTecnicaGabrielBorja.Service;

import com.tata.pruebaTecnicaGabrielBorja.Dto.ClienteDto;
import com.tata.pruebaTecnicaGabrielBorja.Dto.CuentaDto;
import com.tata.pruebaTecnicaGabrielBorja.Dto.MovimientosDto;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cliente;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cuenta;
import com.tata.pruebaTecnicaGabrielBorja.Model.Movimiento;
import com.tata.pruebaTecnicaGabrielBorja.Repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class MovimientoService {

    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MovimientoRepository movimientoRepository;
    public List<MovimientosDto> getAllMovimientos(){
        List<MovimientosDto> response = new ArrayList<MovimientosDto>();
        List<Movimiento> result = this.movimientoRepository.findAll();
        for(int i=0;i<result.size();i++){
            MovimientosDto movimientosDto = new MovimientosDto();
            movimientosDto.setNumeroCuenta(result.get(i).getCuenta().getNumerocuenta());
            movimientosDto.setIdMovimiento(result.get(i).getIdMovimiento());
            movimientosDto.setTipoMovimiento(result.get(i).getTipoMovimiento());
            movimientosDto.setFecha(result.get(i).getFecha());
            movimientosDto.setSaldo(result.get(i).getSaldo(movimientosDto.getSaldo()));
            movimientosDto.setValor(result.get(i).getValor());
            response.add(movimientosDto);
        }
        System.out.println(response.toString());
        return response;
    }

    public MovimientosDto getbyId(Integer Id){
        MovimientosDto movimientosDto = new MovimientosDto();
    try{
        Movimiento result = this.movimientoRepository.getReferenceById(Id);
        movimientosDto.setNumeroCuenta(result.getCuenta().getNumerocuenta());
        movimientosDto.setIdMovimiento(result.getIdMovimiento());
        movimientosDto.setTipoMovimiento(result.getTipoMovimiento());
        movimientosDto.setFecha(result.getFecha());
        movimientosDto.setSaldo(result.getSaldo(movimientosDto.getSaldo()));
        movimientosDto.setValor(result.getValor());

    }catch (Exception e){
        movimientosDto.setNumeroCuenta("NO EXISTE ESE NUMERO DE CUENTA");
    }
        return movimientosDto;
    }

    public Movimiento saveMovimientos(MovimientosDto movimientosDto) {




        CuentaDto cuentaDto = cuentaService.getbyId(movimientosDto.getNumeroCuenta());

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


        Cuenta cuenta = new Cuenta();
        cuenta.setCliente(cliente);
        cuenta.setTipocuenta(cuentaDto.getTipocuenta());
        cuenta.setSaldoInicial(cuentaDto.getSaldoInicial());
        cuenta.setEstado(cuentaDto.getEstado());
        cuenta.setNumerocuenta(cuentaDto.getNumerocuenta());


        Movimiento m =  new Movimiento();
        LocalDateTime hoy = LocalDateTime.now();
        m.setCuenta(cuenta);
        m.setIdMovimiento(movimientosDto.getIdMovimiento());
        m.setFecha(hoy.toString());
        m.setTipoMovimiento(movimientosDto.getTipoMovimiento());
        m.setValor(movimientosDto.getValor());

        Integer saldo =0;
        Integer valor =0;
        saldo = Integer.valueOf(cuenta.getSaldoInicial());
        valor = m.getValor();
        if(saldo>0){
        saldo=saldo-valor;
            m.setSaldo(saldo);
            CuentaDto cuentasSaldo = new CuentaDto();
            cuentasSaldo.setClienteid(cliente.getClienteid());
            cuentasSaldo.setTipocuenta(cuentaDto.getTipocuenta());
            cuentasSaldo.setSaldoInicial(String.valueOf(saldo));
            cuentasSaldo.setEstado(cuentaDto.getEstado());
            cuentasSaldo.setNumerocuenta(cuentaDto.getNumerocuenta());
            cuentaService.saveCuentas(cuentasSaldo);
        System.out.println("SALDO: "+saldo);
        }else{
            System.out.println("SALDO NO DISPONIBLE "+saldo);
        }

        this.movimientoRepository.save(m);



        return m;
    }

    public Boolean deleteMovimiento(Integer id) {
        this.movimientoRepository.deleteById(id);
        return true;
    }
    
}