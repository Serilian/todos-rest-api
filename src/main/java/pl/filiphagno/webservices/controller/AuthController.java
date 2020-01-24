package pl.filiphagno.webservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.filiphagno.basicauth.AuthenticationBean;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @GetMapping("/basicauth")
    public AuthenticationBean helloWorld() {
        return new AuthenticationBean("Hello from Spring Boot");
    }


}

