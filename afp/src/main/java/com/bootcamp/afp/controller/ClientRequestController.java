package com.bootcamp.afp.controller;

import com.bootcamp.afp.model.AfpModel;
import com.bootcamp.afp.model.ClientRequestModel;
import com.bootcamp.afp.service.ClientRequestService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clientRequest")
public class ClientRequestController {

    @Autowired
    private final ClientRequestService clientRequestService;

    private static final Logger LOGGER =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientRequestModel> getAll(){
        List<ClientRequestModel> response=clientRequestService.findAll();
        LOGGER.info("Listado de solicitudes");
        return  response;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String create(@RequestBody ClientRequestModel clientRequestModel){
        String response = clientRequestService.create(clientRequestModel);
        LOGGER.info("Se creo nueva solicitud");
        return  response;
    }

}
