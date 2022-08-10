package com.example.carros.domain;

public class CarroResponse {

    private Long id;
    private String nome;
    private String tipo;

    public CarroResponse() {

    }

    public CarroResponse(Long id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarroResponse withBuilderId(Long id){
        setId(id);
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CarroResponse withBuilderNome(String nome){
        setNome(nome);
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CarroResponse withBuilderTipo(String tipo){
        setTipo(tipo);
        return this;
    }

}
