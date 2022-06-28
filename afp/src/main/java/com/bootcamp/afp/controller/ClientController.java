package com.bootcamp.afp.controller;

import com.bootcamp.afp.model.ClientModel;
import com.bootcamp.afp.service.IClientService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/client")
public class ClientController {
    @Autowired
    private final IClientService clientService;

    private static final Logger LOGGER =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientModel> getAll(){
        //Lista de los clientes de AFP
        List<ClientModel> response = clientService.findAll();
        LOGGER.info("Listado de Clientes");
        return response;
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientModel getById(@PathVariable(value = "id") Long id){
        //Busqueda del Cliente por id
        ClientModel response = clientService.findById(id);
        LOGGER.info("Se buscó cliente");
        return response;
    }

    @GetMapping("/getByDni/{dni}")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientModel> getByDni(@PathVariable(value = "dni") String dni){
        //Busqueda del Cliente por dni
        List<ClientModel> response = clientService.findByDni(dni);
        LOGGER.info("Se buscó cliente");
        return response;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ClientModel create(@RequestBody ClientModel clientModel){
        //creacion del nuevo cliente
        ClientModel response = clientService.create(clientModel);
        LOGGER.info("Se creo nuevo cliente");
        return response;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") Long id, @RequestBody ClientModel clientModel){
        //actualizacion del nuevo cliente
        clientService.update(id,clientModel);
        LOGGER.info("Se actualizó cliente");
        return  "Se actualizó registro";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable("id") Long id){
        //Eliminiacion del cliente
        clientService.deleteById(id);
        LOGGER.info("Se eliminó registro");
        return "Se eliminó registro";
    }

}
