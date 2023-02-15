package com.example.carros.domain;



import javax.validation.constraints.NotNull;


public class CarroRequest {

    @NotNull
    private String nome;

    @NotNull
    private String tipo;

    public CarroRequest() {

    }

    public CarroRequest(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;

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
}
