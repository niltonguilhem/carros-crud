package com.example.carros.service;

import com.example.carros.domain.Carro;
import com.example.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public List<Carro> findAllCarro() { return repository.findAll();}

    public Carro getCarroById(Long id){return repository.findById(id).get();}
    public Optional<Carro> getCarroByIdOptional(Long id) {
        return  repository.findById(id);
    }

    public Iterable<Carro> getCarroByTipo (String tipo) {
        return repository.findByTipo(tipo);
    }

    public Carro save (Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return repository.save(carro);
    }

    public Carro update(Carro carro) {

        Optional<Carro> optional = getCarroByIdOptional(carro.getId());
        if (optional.isPresent()) {
            Carro carroEntity = carro;
            carroEntity.setNome(carro.getNome());
            carroEntity.setTipo(carro.getTipo());

            repository.save(carroEntity);

            return carroEntity;
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarroByIdOptional(id);
        if(carro.isPresent()) {
            repository.deleteById(id);
        }
    }

}

