package com.bootcamp.afp.service;

import com.bootcamp.afp.domain.Client;
import com.bootcamp.afp.mapper.ClientMapper;
import com.bootcamp.afp.model.ClientModel;
import com.bootcamp.afp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService{

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    private static final Logger LOGGER =  LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public List<ClientModel> findAll(){
        List<Client> clients = clientRepository.findAll();
        return clientMapper.clientsToClientModels(clients);
    }

     @Override
    public ClientModel findById(Long id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) return clientMapper.clientToClientModel(client.get());
        else return clientMapper.clientToClientModel(null);
    }

    @Override
    public List<ClientModel> findByDni(String dni){
        //Obtener el cliente buscando por el DNI
        List<Client> clients = clientRepository.findByDni(dni);

        return clientMapper.clientsToClientModels(clients);
    }


    @Override
    public ClientModel create (ClientModel clientModel){
        Client client = clientRepository.save(clientMapper.clientModelToClient(clientModel));
        return clientMapper.clientToClientModel(client);
    }

    @Override
    public void update (Long id, ClientModel clientModel){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()){
            Client client = clientOptional.get();
            clientMapper.update(client,clientModel);
            clientRepository.save(client);
        }
    }

   @Override
    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

}
