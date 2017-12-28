package fr.home.app.planner;

import fr.home.app.planner.model.Login;

public interface IJwtUserServices {
    JwtUser authenticate(Login login);
}
