package com.bootcamp.afp.controller;

import com.bootcamp.afp.model.AfpModel;
import com.bootcamp.afp.service.AfpService;
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
@RequestMapping("/api/afp")
public class AfpController {

    @Autowired
    private final AfpService afpService;

    private static final Logger LOGGER =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<AfpModel> getAll(){
        List<AfpModel> response=afpService.findAll();
        LOGGER.info("Listado de AFPs");
        return  response;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public AfpModel create(@RequestBody AfpModel afpModel){
        AfpModel response = afpService.create(afpModel);
        LOGGER.info("Se creo nueva AFP");
        return  response;
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("id") Long id, @RequestBody AfpModel afpModel){
        afpService.update(id, afpModel);
        return ("Se actualizó registro");
    }

}
