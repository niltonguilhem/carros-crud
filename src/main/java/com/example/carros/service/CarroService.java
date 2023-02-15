package com.example.carros.service;

import com.example.carros.domain.Carro;
import com.example.carros.handler.exception.EntidadeInexistenteException;
import com.example.carros.repository.CarroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private static final Logger logger = LoggerFactory.getLogger(CarroService.class);

    @Autowired
    private CarroRepository repository;

    public List<Carro> findAllCarro() {
        logger.info("m=findAllCarro - status=start");
        List<Carro> carroList = repository.findAll();
        logger.info("m=findAllCarro - status= finish");
        return carroList;}

    public Carro getCarroById(Long id){
        logger.info("m=getCarroById - status=start " + id);
        Carro carro = repository.findById(id)
                        .orElseThrow(() -> new EntidadeInexistenteException(
                                String.format("Não existe vaga com este id %d",id)));
        logger.info("m=getCarroById - status=finish " + id);
        return carro;
    }
    public Optional<Carro> getCarroByIdOptional(Long id) {
        logger.info("m=getCarroByIdOptional - status=start " + id);
        Optional<Carro> carroOptional = repository.findById(id);
        logger.info("m=getCarroByIdOptional - status=finish " + id);
        return  carroOptional;
    }

    public List<Carro> getCarroByTipo (String tipo) {
        logger.info("m=getCarroByTipo - status=start " + tipo);
        List<Carro> carroList = repository.findByTipo(tipo);
        logger.info("m=getCarroByTipo - status=finish " + tipo);
        return carroList;
    }

    public Carro save (Carro carro) {
        logger.info("m=save - status=start");
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        logger.info("m=save - status=finish");
        return repository.save(carro);
    }

    public Carro update(Carro carro) {
        logger.info("m=update - status=start " + carro.getId());
        Optional<Carro> optional = getCarroByIdOptional(carro.getId());
        if (optional.isPresent()) {
            Carro carroEntity = carro;
            carroEntity.setNome(carro.getNome());
            carroEntity.setTipo(carro.getTipo());
            repository.save(carroEntity);
            logger.info("m=update - status=finish " + carro.getId());
            return carroEntity;
        } else {
            logger.warn("m=update - status=warn " + carro.getId());
            throw new EntidadeInexistenteException("O id "+ carro.getId() + " informado é inexistente.");
        }
    }

    public void delete(Long id) {
        logger.info("m=delete - status=start " + id);
        Optional<Carro> carro = getCarroByIdOptional(id);
        if(carro.isPresent()) {
            logger.info("m=delete - status=finish " + id);
            repository.deleteById(id);
        } else {
            logger.warn("m=delete - status=warn " + id);
            throw new EntidadeInexistenteException ("O id "+ id +" informado é inexistente." );
        }
    }

}

