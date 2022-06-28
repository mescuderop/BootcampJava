package com.bootcamp.afp.service;

import com.bootcamp.afp.model.ClientRequestModel;

import java.util.List;

public interface IClientRequestService {
    List<ClientRequestModel> findAll();
    String create (ClientRequestModel clientRequestModel);
}
