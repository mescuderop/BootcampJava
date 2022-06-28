package com.bootcamp.afp.controller;

import com.bootcamp.afp.model.ClientAccountModel;
import com.bootcamp.afp.model.ClientModel;
import com.bootcamp.afp.service.ClientAccountService;
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
@RequestMapping("api/clientAccount")
public class ClientAccountController {

    @Autowired
    private final ClientAccountService clientAccountService;

    private static final Logger LOGGER =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientAccountModel> getAll(){
        List<ClientAccountModel> response = clientAccountService.findAll();
        LOGGER.info("Se lista informacion total de las AFP");
        return response;

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ClientAccountModel create(@RequestBody ClientAccountModel clientAccountModel){
        ClientAccountModel response= clientAccountService.create(clientAccountModel);
        LOGGER.info("Se creo nuevo registro");
        return response;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") Long id, @RequestBody ClientAccountModel clientAccountModel){
        clientAccountService.update(id,clientAccountModel);
        LOGGER.info("Se actualizó registro");
        return  "Se actualizó registro";
    }





}
