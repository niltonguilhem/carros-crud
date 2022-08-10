package com.example.carros.repository;

import com.example.carros.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    Iterable<Carro> findByTipo(String tipo);
}
