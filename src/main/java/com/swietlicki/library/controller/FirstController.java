package com.swietlicki.library.controller;

import com.swietlicki.library.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    private final FirstService firstService;

    @Autowired
    public FirstController(FirstService firstService) {
        this.firstService = firstService;
    }

    @GetMapping("/")
    public String hello() {
        return firstService.hello();
    }
}
