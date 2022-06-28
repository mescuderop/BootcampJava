package com.bootcamp.afp.service;

import com.bootcamp.afp.model.AfpModel;

import java.util.List;

public interface IAfpService {
    List<AfpModel> findAll();
    AfpModel create(AfpModel afpModel);
    void update(Long id, AfpModel afpModel);
}
