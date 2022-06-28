package com.bootcamp.afp.service;

import com.bootcamp.afp.model.ClientAccountModel;

import java.util.List;

public interface IClientAccountService {
    List<ClientAccountModel> findAll();
    ClientAccountModel create (ClientAccountModel clientAccountModel);
    void update (Long id, ClientAccountModel clientAccountModel);
}
