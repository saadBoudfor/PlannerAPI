package fr.home.app.planner;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }


    @DeleteMapping("/{id}")
    public Long deleteUser(@PathVariable("id") Long userId) {
        userRepository.delete(userId);
        return userId;
    }

    @GetMapping("/loggedUser")
    public Map<Object, Object> getLoggedUser(HttpServletRequest httpRequest) {
        HttpSession httpSession = httpRequest.getSession();
        SecurityContext httpContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
        String name = httpContext.getAuthentication().getName();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority ga : httpContext.getAuthentication().getAuthorities()) {
            roles.add(ga.getAuthority());
        }
        Map<Object, Object> param = new HashMap<>();
        param.put("name", name);
        param.put("roles", roles);
        return param;
    }

}
