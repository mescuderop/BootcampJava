package com.bootcamp.afp.mapper;

import com.bootcamp.afp.domain.ClientAccount;
import com.bootcamp.afp.model.ClientAccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientAccountMapper {

    ClientAccount clientAccountModelToClientAccount(ClientAccountModel clientAccountModel);
    ClientAccountModel clientAccountToClientAccountModel(ClientAccount clientAccount);
    List<ClientAccountModel> clientsAccountToClientsAccountModels(List<ClientAccount> clientAccounts);

    void update(@MappingTarget ClientAccount clientAccount, ClientAccountModel updateClientAccount);


}
