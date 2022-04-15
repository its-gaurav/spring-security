package demo.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    @GetMapping("/say-hello")
    public String getName(@RequestParam("name") String name){
        return "Hello " + name;
    }
}
