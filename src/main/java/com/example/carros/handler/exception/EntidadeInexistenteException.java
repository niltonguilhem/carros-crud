package com.example.carros.handler.exception;

import org.springframework.http.HttpStatus;

public class EntidadeInexistenteException extends RuntimeException {

    public EntidadeInexistenteException(String mensagem) {super(mensagem);}

}
