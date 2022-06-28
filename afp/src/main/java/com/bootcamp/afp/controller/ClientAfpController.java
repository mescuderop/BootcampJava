package com.bootcamp.afp.controller;

import com.bootcamp.afp.model.ClientAfpModel;
import com.bootcamp.afp.model.ClientModel;
import com.bootcamp.afp.service.IClientAfpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientAfp")
public class ClientAfpController {

    @Autowired
    public IClientAfpService clientAfpService;

    private static final Logger LOGGER =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/listAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientAfpModel> getAll(){
        List<ClientAfpModel> response = clientAfpService.findAll();
        LOGGER.info("Listado de Clientes");
        return response;
    }

    @PostMapping("/createLink")
    @ResponseStatus(HttpStatus.OK)
    public ClientAfpModel createLinkClientToAfp(@RequestBody ClientAfpModel clientAfpModel){
        ClientAfpModel response = clientAfpService.create(clientAfpModel);
        LOGGER.info("Se vinculó cliente con AFP");
        return response;
    }

    @PutMapping("/updateLink/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") Long id, @RequestBody ClientAfpModel clientAfpModel){
        clientAfpService.update(id,clientAfpModel);
        LOGGER.info("Se actualizó vinculo de cliente con AFP");
        return  "Se actualizó registro";
    }

}
