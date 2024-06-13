package com.tata.pruebaTecnicaGabrielBorja.Controller;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.net.server.Client;
import com.tata.pruebaTecnicaGabrielBorja.Dto.ClienteDto;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cliente;
import com.tata.pruebaTecnicaGabrielBorja.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<?> getClientes() {
        List<ClienteDto> c = this.clienteService.getAllClientes();
        if (c.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
        } else {
            return ResponseEntity.ok().body(c);
        }

    }
    @GetMapping("/clienteById/{id}")
    public ResponseEntity<?> getClientesById(@PathVariable Integer id){
        ClienteDto c = this.clienteService.getbyId(id);
        if (c.equals(null)) {
            return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
        } else {
            return ResponseEntity.ok().body(c);
        }

    }

    @PostMapping("/cliente")
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente) {
        Cliente c = this.clienteService.saveCliente(cliente);
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Integer id) {
        boolean c= this.clienteService.deleteCliente(id);
        if (c==true) {
            return ResponseEntity.ok("Borrardo");
        }
        return ResponseEntity.badRequest().body(Map.of("mensage", "Cero objectos encontrados"));
    }


}