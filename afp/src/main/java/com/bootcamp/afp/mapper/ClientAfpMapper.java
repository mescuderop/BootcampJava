package com.bootcamp.afp.mapper;

import com.bootcamp.afp.domain.ClientAfp;
import com.bootcamp.afp.model.ClientAccountModel;
import com.bootcamp.afp.model.ClientAfpModel;
import com.bootcamp.afp.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientAfpMapper {
    ClientAfp clientAfpModelToClientAfp(ClientAfpModel clientAfpModel);
    ClientAfpModel clientAfpToClientAfpModel(ClientAfp clientAfp);
    List<ClientAfpModel> clientsAfpToClientsAfpModel(List<ClientAfp> clientAfps);
    void update (@MappingTarget ClientAfp clientAfp, ClientAfpModel updateClientAfp);

}
