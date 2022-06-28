package com.bootcamp.afp.mapper;

import com.bootcamp.afp.domain.ClientRequest;
import com.bootcamp.afp.model.ClientRequestModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientRequestMapper {

    ClientRequest clientRequestModelToClientRequest(ClientRequestModel clientRequestModel);

    ClientRequestModel clientRequestToClientRequestModel(ClientRequest clientRequest);

    List<ClientRequestModel> clientsRequestToClientsRequestModel(List<ClientRequest> clientRequests);

}
