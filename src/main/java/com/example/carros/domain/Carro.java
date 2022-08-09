package com.example.carros.domain;

import javax.persistence.*;

@Entity
@Table (name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipo")
    private String tipo;

    public Carro() {

    }

    public Carro(Long id, String nome) { // criação do construtor com a tecla alt + insert.
        this.id = id;
        this.nome = nome;
        this.tipo =tipo;

    }

    //para criar os Get & Set é necessário manter apertado as teclas alt + insert (exatamente nesta linha).
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
}
