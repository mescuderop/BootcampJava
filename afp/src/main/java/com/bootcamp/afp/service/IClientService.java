package com.bootcamp.afp.service;

import com.bootcamp.afp.model.ClientModel;

import java.util.List;

public interface IClientService {

    List<ClientModel> findAll();
    ClientModel findById(Long id);
    List<ClientModel> findByDni(String dni);
    ClientModel create (ClientModel clientModel);
    void update (Long id, ClientModel clientModel);
    void deleteById(Long id);
}
