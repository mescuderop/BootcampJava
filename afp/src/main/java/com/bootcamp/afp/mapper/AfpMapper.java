package com.bootcamp.afp.mapper;

import com.bootcamp.afp.domain.Afp;
import com.bootcamp.afp.model.AfpModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AfpMapper {
    Afp afpModelToAfp(AfpModel afpModel);
    AfpModel afpToAfpModel(Afp afp);
    List<AfpModel> afpsToAfpModels(List<Afp> afps);
    void update(@MappingTarget Afp afp, AfpModel afpModel);

}
