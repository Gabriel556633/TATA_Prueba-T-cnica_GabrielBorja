package com.tata.pruebaTecnicaGabrielBorja.Controller;

import com.tata.pruebaTecnicaGabrielBorja.Dto.ClienteDto;
import com.tata.pruebaTecnicaGabrielBorja.Dto.CuentaDto;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cliente;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cuenta;
import com.tata.pruebaTecnicaGabrielBorja.Service.ClienteService;
import com.tata.pruebaTecnicaGabrielBorja.Service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cuentas")
    public ResponseEntity<?> getCuentas() {
        List<CuentaDto> c = this.cuentaService.getAllCuentas();
        if (c.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
        } else {
            return ResponseEntity.ok().body(c);
        }

    }
    @GetMapping("/cuentaById/{id}")
    public ResponseEntity<?> getCuentaById(@PathVariable String id){
        CuentaDto c = this.cuentaService.getbyId(id);
        if (c.equals(null)) {
            return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
        } else {
            return ResponseEntity.ok().body(c);
        }

    }

     @PostMapping("/cuenta")
    public ResponseEntity<?> createCuenta(@RequestBody CuentaDto cuentadto) {

         try{
            Cuenta c = this.cuentaService.saveCuentas(cuentadto);

             return ResponseEntity.ok().body(c);
         }catch (Exception e){
             return ResponseEntity.badRequest().body(Map.of(e, "Cedula Incorrecta"));
         }
    }



    @DeleteMapping("/cuenta/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable String id) {
        boolean c= this.cuentaService.deleteCuenta(id);
        if (c==true) {
            return ResponseEntity.ok("Borrardo");
        }
        return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
    }


}