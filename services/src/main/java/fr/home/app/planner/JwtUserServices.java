package fr.home.app.planner;

import fr.home.app.planner.exceptions.PlannerServicesException;
import fr.home.app.planner.exceptions.PlannerServicesExceptionMassages;
import fr.home.app.planner.model.Login;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@Component
public class JwtUserServices implements IJwtUserServices {
    private JwtUserRepository jwtUserRepository;

    private JwtUser getUser(Login login) {
        JwtUser jwtUser = jwtUserRepository.findJwtUserByUserName(login.getUserName());
        if (StringUtils.isEmpty(jwtUser)) {
            throw new PlannerServicesException(PlannerServicesExceptionMassages.USER_NOT_FOUND);
        } else {
            return jwtUser;
        }
    }

    public JwtUser authenticate(Login login) {
        JwtUser jwtUser = getUser(login);
        if (login.getPassword().equals(jwtUser.getPassword())) {
            return jwtUser;
        } else {
            throw new PlannerServicesException(PlannerServicesExceptionMassages.AUTHENTICATION_FAILED);
        }
    }

}
