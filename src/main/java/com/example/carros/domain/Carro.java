package com.example.carros.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private String tipo;

    public Carro() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Carro withBuilderNome(String nome){
        setNome(nome);
        return this;
    }

    public Carro withBuilderTipo(String tipo){
        setTipo(tipo);
        return this;
    }

    public Carro withBuilderId(Long id){
        setId(id);
        return this;
    }

}
