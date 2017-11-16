package fr.home.app.planner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private JpaUserRepository jpaUserRepository;

    public UserController(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @GetMapping(value = "/all")
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @PostMapping(value = "/load")
    public User loaduser(@RequestBody final User user) {
        jpaUserRepository.save(user);
        return jpaUserRepository.findByEmail(user.getEmail());
    }
}
