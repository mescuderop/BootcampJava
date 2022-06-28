package com.bootcamp.afp.mapper;

import com.bootcamp.afp.domain.Client;
import com.bootcamp.afp.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client clientModelToClient(ClientModel clientModel);
    ClientModel clientToClientModel(Client client);
    List<ClientModel> clientsToClientModels (List<Client> clients);

    void update (@MappingTarget Client client, ClientModel updateClient);

}
