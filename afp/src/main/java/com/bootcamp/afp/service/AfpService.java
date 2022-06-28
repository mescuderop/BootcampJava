package com.bootcamp.afp.service;

import com.bootcamp.afp.domain.Afp;
import com.bootcamp.afp.mapper.AfpMapper;
import com.bootcamp.afp.model.AfpModel;
import com.bootcamp.afp.repository.AfpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AfpService implements IAfpService{
    private final AfpRepository afpRepository;
    private final AfpMapper afpMapper;

    @Override
    public List<AfpModel> findAll(){
        //Lista de los Afp registrados
        List<Afp> listAfps = afpRepository.findAll();
        return afpMapper.afpsToAfpModels(listAfps);
    }


    @Override
    public AfpModel create(AfpModel afpModel){
        //Creacion de un nuevo registro AFP
        afpModel.setName(afpModel.getName().toUpperCase()); //Se setea el nombre en mayuscula
        Afp afp = afpRepository.save(afpMapper.afpModelToAfp(afpModel));
        return afpMapper.afpToAfpModel(afp);
    }

    @Override
    public void update(Long id, AfpModel afpModel){
        //Actualizacion del nombre de la afp
        Optional<Afp> afpOptional = afpRepository.findById(id);
        if(afpOptional.isPresent()){
            Afp afp = afpOptional.get();
            afpMapper.update(afp,afpModel);
            afpRepository.save(afp);
        }
    }

}
