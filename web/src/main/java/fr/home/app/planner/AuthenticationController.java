package fr.home.app.planner;

import fr.home.app.planner.model.Login;
import fr.home.app.planner.security.JwtGenerator;
import fr.home.app.planner.views.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private JwtGenerator jwtGenerator;
    private JwtUserServices jwtUserServices;
    private AuthenticationProcess authenticationProcess;

    @PostMapping("/token")
    public String generate(@RequestBody Login login) {
        return jwtGenerator.generate(jwtUserServices.authenticate(login));
    }

    @PostMapping("/enrolment")
    public String createAccount(@RequestBody UserView userView) {
        authenticationProcess.createAccount(userView);
        return userView.getUsername();
    }
}

