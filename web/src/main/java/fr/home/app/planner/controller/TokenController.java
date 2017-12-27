package fr.home.app.planner.controller;

import fr.home.app.planner.JwtUser;
import fr.home.app.planner.JwtUserRepository;
import fr.home.app.planner.model.Login;
import fr.home.app.planner.security.JwtGenerator;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;
    private JwtUserRepository jwtUserRepository;

    @PostMapping
    public String generate(@RequestBody final Login login) {
        JwtUser jwtUser = jwtUserRepository.findJwtUserByUserName(login.getUserName());
        if (StringUtils.isEmpty(jwtUser)) {
            throw new AuthenticationException("User does not exist");
        }
        return jwtGenerator.generate(jwtUser);
    }
}

class AuthenticationException extends RuntimeException {
    AuthenticationException(String exception) {
        super(exception);
    }
}
