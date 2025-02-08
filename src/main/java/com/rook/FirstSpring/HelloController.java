package com.rook.FirstSpring;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return new HelloResponse("Hello World!").toString();
    }

    @PostMapping("/hello")
    public String sayHelloPost(@RequestBody String name) {
        return new HelloResponse(name).toString();
    }
}
