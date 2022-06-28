package com.bootcamp.afp.service;

import com.bootcamp.afp.domain.Client;
import com.bootcamp.afp.domain.ClientAccount;
import com.bootcamp.afp.mapper.ClientAccountMapper;
import com.bootcamp.afp.model.ClientAccountModel;
import com.bootcamp.afp.model.ClientModel;
import com.bootcamp.afp.repository.ClientAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientAccountService implements IClientAccountService{

    private final ClientAccountRepository clientAccountRepository;
    private final ClientAccountMapper clientAccountMapper;

    @Override
    public List<ClientAccountModel> findAll(){
        //Lista de las cuentas de afp creadas de los clientes
        List<ClientAccount> clientAccounts = clientAccountRepository.findAll();
        return clientAccountMapper.clientsAccountToClientsAccountModels(clientAccounts);
    }

    @Override
    public ClientAccountModel create (ClientAccountModel clientAccountModel){
        //Creacion de la cuenta afp para el cliente
        ClientAccount clientAccount = clientAccountRepository.save(clientAccountMapper.clientAccountModelToClientAccount(clientAccountModel));
        return clientAccountMapper.clientAccountToClientAccountModel(clientAccount);
    }

    @Override
    public void update (Long id, ClientAccountModel clientAccountModel){
        //Actualizacion de la cuenta afp para el cliente
        Optional<ClientAccount> clientOptional = clientAccountRepository.findById(id);
        if(clientOptional.isPresent()){
            ClientAccount clientAccount = clientOptional.get();
            clientAccountMapper.update(clientAccount,clientAccountModel);
            clientAccountRepository.save(clientAccount);
        }
    }

}
