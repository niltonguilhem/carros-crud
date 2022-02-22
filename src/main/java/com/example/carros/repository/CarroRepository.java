package com.example.carros.repository;

import com.example.carros.domain.Carro;
import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long> {
    Iterable<Carro> findByTipo(String tipo);
}
