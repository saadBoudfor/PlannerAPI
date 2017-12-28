package fr.home.app.planner.controller;

import fr.home.app.planner.JwtUserServices;
import fr.home.app.planner.model.Login;
import fr.home.app.planner.security.JwtGenerator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;
    private JwtUserServices jwtUserServices;

    @PostMapping
    public String generate(@RequestBody final Login login) {
        return jwtGenerator.generate(jwtUserServices.authenticate(login));
    }
}

