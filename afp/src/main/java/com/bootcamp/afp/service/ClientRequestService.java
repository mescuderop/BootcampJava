package com.bootcamp.afp.service;

import com.bootcamp.afp.domain.Client;
import com.bootcamp.afp.domain.ClientAccount;
import com.bootcamp.afp.domain.ClientRequest;
import com.bootcamp.afp.mapper.ClientRequestMapper;
import com.bootcamp.afp.model.ClientModel;
import com.bootcamp.afp.model.ClientRequestModel;
import com.bootcamp.afp.repository.ClientAccountRepository;
import com.bootcamp.afp.repository.ClientRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientRequestService implements IClientRequestService {

    private final ClientRequestRepository clientRequestRepository;
    private final ClientAccountRepository clientAccountRepository;

    private final ClientRequestMapper clientRequestMapper;


    @Override
    public List<ClientRequestModel> findAll(){
        //Se lista las solicitudes de retiros de los clientes
        List<ClientRequest> clientRequestModels = clientRequestRepository.findAll();
        return clientRequestMapper.clientsRequestToClientsRequestModel(clientRequestModels);
    }

    @Override
    public String create (ClientRequestModel clientRequestModel){
        //se crea nueva solicitud de retiro de afp
        Optional<ClientAccount> optionalClientAccount= clientAccountRepository.findById(clientRequestModel.getClient_account_id());
        if(optionalClientAccount.isPresent()){
            ClientAccount clientAccount= optionalClientAccount.get();
            if(clientRequestModel.getAmount()>clientAccount.getAmount())
            {
                return "No se puede registrar la solicitud. Monto maytor que el permitido";
            }
            else{
                if(clientRequestModel.getAmount() < (clientAccount.getAmount() * 0.5)){
                    return "Monto minimo no cubierto por favor revise el monto minimo a retirar";
                }else{
                    ClientRequest clientRequest = clientRequestRepository.save(clientRequestMapper.clientRequestModelToClientRequest(clientRequestModel));

                    return "Solicitud Registrada";
                }
            }
        }
        else return "No se encontro cuenta del asociado";

    }

}
