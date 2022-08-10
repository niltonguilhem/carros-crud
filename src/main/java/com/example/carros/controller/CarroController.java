package com.example.carros.controller;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroRequest;
import com.example.carros.domain.CarroResponse;
import com.example.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api/v1/carros")
public class CarroController {
    @Autowired
    private CarroService service;

    @GetMapping()
    public ResponseEntity<List<CarroResponse>> getAllCarro() {
        List<Carro> carroList = service.findAllCarro();
        List<CarroResponse> carroResponseList = carroList.stream().map(carro -> new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo())).collect(Collectors.toList());
        return new ResponseEntity<>(carroResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponse> getId(@PathVariable("id") Long id) {
        Carro carro = service.getCarroById(id);
        CarroResponse response = new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo());

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    /*@GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getTipo (@PathVariable ("tipo") String tipo ) {
        return service.getCarroByTipo(tipo);
    }*/
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<CarroResponse> getTipo(@PathVariable("tipo") String tipo) {
        Carro carro = (Carro) service.getCarroByTipo(tipo);
        CarroResponse response = new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarroResponse> postCarro(@RequestBody CarroRequest carroRequest){

        Carro carro = service.save(new Carro()
                .withBuilderNome(carroRequest.getNome())
                .withBuilderTipo(carroRequest.getTipo()));

        CarroResponse response = new CarroResponse()
                .withBuilderId(carro.getId())
                .withBuilderNome(carro.getNome())
                .withBuilderTipo(carro.getTipo());

        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponse> putCarro (@PathVariable("id")Long id,
                                                       @RequestBody CarroRequest carroRequest){

        Carro carroUpdate = service.update(new Carro()
                .withBuilderId(id)
                .withBuilderNome(carroRequest.getNome())
                .withBuilderTipo(carroRequest.getTipo()));

        CarroResponse response = new CarroResponse()
                .withBuilderId(carroUpdate.getId())
                .withBuilderNome(carroUpdate.getNome())
                .withBuilderTipo(carroUpdate.getTipo());


        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  String delete(@PathVariable("id") Long id) {

        service.delete(id);

        return "Carro deletado com sucesso";
    }


}
