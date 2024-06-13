package com.tata.pruebaTecnicaGabrielBorja.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tata.pruebaTecnicaGabrielBorja.Dto.ClienteDto;
import com.tata.pruebaTecnicaGabrielBorja.Model.Cliente;
import com.tata.pruebaTecnicaGabrielBorja.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    public List<ClienteDto> getAllClientes(){
        List<ClienteDto> response = new ArrayList<ClienteDto>();
        List<Cliente> result = this.clienteRepository.findAll();
        for(int i=0;i<result.size();i++){
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(result.get(i).getId());
            clienteDto.setClienteid(result.get(i).getClienteid());
            clienteDto.setContraseña(result.get(i).getContraseña());
            clienteDto.setdireccion(result.get(i).getDireccion());
            clienteDto.setEdad(result.get(i).getEdad());
            clienteDto.setEstado(result.get(i).getEstado());
            clienteDto.setGenero(result.get(i).getGenero());
            clienteDto.setIdentificacion(result.get(i).getIdentificacion());
            clienteDto.setNombre(result.get(i).getNombre());
            clienteDto.setTelefono(result.get(i).getTelefono());
            response.add(clienteDto);
        }
        System.out.println(response.toString());
        return response;
    }

    public ClienteDto getbyId(Integer Id){

        Cliente result = this.clienteRepository.getReferenceById(Id);

            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(result.getId());
            clienteDto.setClienteid(result.getClienteid());
            clienteDto.setContraseña(result.getContraseña());
            clienteDto.setdireccion(result.getDireccion());
            clienteDto.setEdad(result.getEdad());
            clienteDto.setEstado(result.getEstado());
            clienteDto.setGenero(result.getGenero());
            clienteDto.setIdentificacion(result.getIdentificacion());
            clienteDto.setNombre(result.getNombre());
            clienteDto.setTelefono(result.getTelefono());
        return clienteDto;
    }
    public Cliente saveCliente(Cliente cliente) {
        cliente.setId(cliente.getClienteid());
        return this.clienteRepository.save(cliente);
    }

    public Boolean deleteCliente(Integer id) {
        this.clienteRepository.deleteById(id);
        return true;
    }
    
}