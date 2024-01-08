package cat.itacademy.barcelonactiva.camps.maya.s04.t01.n01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/HelloWorld")
    public String salute(@RequestParam(value = "name", defaultValue = "UNKNOWN") String name){
        return "Hi, " + name + ". You're executing a Maven project";
    }

    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{name}"})
    public String salute2(@PathVariable(required = false, value = "name") String name){
        if (name == null){
            return "Hi! You're executing a Maven project";
        } else {
            return "Hi, " + name + ". You're executing a Maven project";
        }
    }
}