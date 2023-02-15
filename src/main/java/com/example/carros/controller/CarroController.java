package com.example.carros.controller;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroRequest;
import com.example.carros.domain.CarroResponse;
import com.example.carros.service.CarroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping ("/api/v1/carros")
@Validated
public class CarroController {

    private static final Logger logger = LoggerFactory.getLogger(CarroController.class);
    @Autowired
    private CarroService service;

    @GetMapping()
    public ResponseEntity<List<CarroResponse>> getAllCarro() {
        logger.info("m=getAllCarro - status=start");
        List<Carro> carroList = service.findAllCarro();
        List<CarroResponse> carroResponseList = carroList.stream().map(carro -> new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo())).toList();
        logger.info("m=getAllCarro - status=finish");
        return new ResponseEntity<>(carroResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponse> getIdCarro(@PathVariable("id") Long id) {
        logger.info("m=getIdCarro - status=start " + id);
        Carro carro = service.getCarroById(id);
        CarroResponse response = new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo());
        logger.info("m=getIdCarro - status=finish " + id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CarroResponse>> getTipo(@PathVariable("tipo") String tipo) {
        logger.info("m=getTipo - status=start " + tipo);
        List<Carro> carroList = service.getCarroByTipo(tipo);
        List<CarroResponse> response = carroList.stream().map(carro -> new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo())).collect(Collectors.toList());
        logger.info("m=getTipo - status=finish " + tipo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarroResponse> postCarro(@RequestBody @Valid CarroRequest carroRequest,
                                                   @RequestHeader(value = "Partner") String Partner){
        logger.info("m=postCarro - status=start " + Partner);
        Carro carro = service.save(new Carro()
                .withBuilderNome(carroRequest.getNome())
                .withBuilderTipo(carroRequest.getTipo()));

        CarroResponse response = new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo());
        logger.info("m=postCarro - status=finish " + Partner);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponse> putCarro (@PathVariable("id")Long id,
                                                   @RequestBody CarroRequest carroRequest,
                                                   @RequestHeader(value = "Partner") String Partner){
        logger.info("m=putCarro - status=start " + id + " " + Partner);
        Carro carroUpdate = service.update(new Carro()
                .withBuilderId(id)
                .withBuilderNome(carroRequest.getNome())
                .withBuilderTipo(carroRequest.getTipo()));

        CarroResponse response = new CarroResponse()
                .withBuilderId(carroUpdate.getId())
                .withBuilderNome(carroUpdate.getNome())
                .withBuilderTipo(carroUpdate.getTipo());
        logger.info("m=putCarro - status=finish " + id + " " + Partner);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        logger.info("m=delete - status=start " + id);
        service.delete(id);
        logger.info("m=delete - status=finish " + id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
