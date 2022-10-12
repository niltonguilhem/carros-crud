package com.example.carros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.remote.JMXServerErrorException;
import javax.naming.NamingException;

@SpringBootApplication
public class CarroApplication {

	private static Logger logger = LoggerFactory.getLogger(CarroApplication.class);
	public static void main(String[] args)throws NamingException, JMXServerErrorException {
		logger.info("Iniciando a api de cadastro de veículos");
		SpringApplication.run(CarroApplication.class, args);
		logger.info("API de cadastro de veículos iniciada e pronta para receber requisições");
	}

}
