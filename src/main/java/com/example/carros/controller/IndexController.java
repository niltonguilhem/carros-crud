package com.example.carros.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/")
public class IndexController {

    @GetMapping ()
    public String get() {
        return "API dos Carros ";
    }


}
