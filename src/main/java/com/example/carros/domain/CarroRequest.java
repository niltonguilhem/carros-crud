package com.example.carros.domain;






public class CarroRequest {

    private String nome;

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
