package com.bootcamp.afp.service;

import com.bootcamp.afp.domain.Client;
import com.bootcamp.afp.domain.ClientAfp;
import com.bootcamp.afp.mapper.ClientAfpMapper;
import com.bootcamp.afp.mapper.ClientMapper;
import com.bootcamp.afp.model.AfpModel;
import com.bootcamp.afp.model.ClientAfpModel;
import com.bootcamp.afp.model.ClientModel;
import com.bootcamp.afp.repository.ClientAfpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientAfpService implements IClientAfpService{

    private final ClientAfpRepository clientAfpRepository;
    private final ClientAfpMapper clientAfpMapper;

    @Override
    public ClientAfpModel create(ClientAfpModel clientAfpModel){
        //Se crea el enlace entre el cliente y la afp asignada
        ClientAfp clientAfp= clientAfpRepository.save(clientAfpMapper.clientAfpModelToClientAfp(clientAfpModel));
        return  clientAfpMapper.clientAfpToClientAfpModel(clientAfp);
    }

    @Override
    public void update(Long id, ClientAfpModel clientAfpModel){
        //Se actualiza el enlace entre el cliente y la afp asignada
        Optional<ClientAfp> optionalClientAfp= clientAfpRepository.findById(id);
        if (optionalClientAfp.isPresent()){
            ClientAfp clientAfp = optionalClientAfp.get();
            clientAfpMapper.update(clientAfp,clientAfpModel);
            clientAfpRepository.save(clientAfp);
        }
    }

    @Override
    public List<ClientAfpModel> findAll(){
        //Se lista los enlaces de los clientes con sus respectivas afps (se muesta ids)
        List<ClientAfp> clientAfps = clientAfpRepository.findAll();
        return clientAfpMapper.clientsAfpToClientsAfpModel(clientAfps);
    }



}
