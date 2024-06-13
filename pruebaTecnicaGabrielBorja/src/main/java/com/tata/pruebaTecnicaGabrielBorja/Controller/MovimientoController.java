package com.tata.pruebaTecnicaGabrielBorja.Controller;

import com.tata.pruebaTecnicaGabrielBorja.Dto.CuentaDto;
import com.tata.pruebaTecnicaGabrielBorja.Dto.MovimientosDto;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cuenta;
import com.tata.pruebaTecnicaGabrielBorja.Model.Movimiento;
import com.tata.pruebaTecnicaGabrielBorja.Service.ClienteService;
import com.tata.pruebaTecnicaGabrielBorja.Service.CuentaService;
import com.tata.pruebaTecnicaGabrielBorja.Service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MovimientoController {
    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/movimientos")
    public ResponseEntity<?> getCuentas() {
        List<MovimientosDto> c = this.movimientoService.getAllMovimientos();
        if (c.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
        } else {
            return ResponseEntity.ok().body(c);
        }

    }
    @GetMapping("/movimientoById/{id}")
    public ResponseEntity<?> getMovimientoById(@PathVariable Integer id){
        MovimientosDto c = this.movimientoService.getbyId(id);
        if (c.equals(null)) {
            return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
        } else {
            return ResponseEntity.ok().body(c);
        }

    }

     @PostMapping("/movimiento")
    public ResponseEntity<?> createCuenta(@RequestBody MovimientosDto movimientosDto) {

         try{
            Movimiento c = this.movimientoService.saveMovimientos(movimientosDto);
             return ResponseEntity.ok().body(c);
         }catch (Exception e){
             return ResponseEntity.badRequest().body(Map.of(e, "Cedula Incorrecta"));
         }
    }



    @DeleteMapping("/movimiento/{id}")
    public ResponseEntity<?> deleteMovimiento(@PathVariable Integer id) {
        boolean c= this.movimientoService.deleteMovimiento(id);
        if (c==true) {
            return ResponseEntity.ok("Borrardo");
        }
        return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
    }


}