package pl.filiphagno.webservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.filiphagno.webservices.domain.HelloWorldBean;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/hello-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-path/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name) {
        return new HelloWorldBean("Hello World " + name.substring(0,1).toUpperCase() + name.substring(1));
    }

}
