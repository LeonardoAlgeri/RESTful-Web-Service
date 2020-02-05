package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Ciao%s";
    private static final String template2 = "Addio%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/welcome")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        String frase;
        if (!"".equals(name))
            frase=", "+name;
        else
            frase="";
        return new Greeting(counter.incrementAndGet(), String.format(template+"!", frase));
    }

    @GetMapping("/bye")
    public Greeting bye(@RequestParam(value = "name", defaultValue = "") String name) {
        String frase;
        if (!"".equals(name))
            frase=", "+name;
        else
            frase="";
        return new Greeting(counter.incrementAndGet(), String.format(template2+"!", frase));
    }
}