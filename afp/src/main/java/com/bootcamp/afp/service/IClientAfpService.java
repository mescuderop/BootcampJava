package com.bootcamp.afp.service;

import com.bootcamp.afp.model.ClientAfpModel;

import java.util.List;

public interface IClientAfpService {
    ClientAfpModel create(ClientAfpModel clientAfpModel);
    List<ClientAfpModel> findAll();
    void update(Long id, ClientAfpModel clientAfpModel);
}
