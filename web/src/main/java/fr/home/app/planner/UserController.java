package fr.home.app.planner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JpaUserRepository jpaUserRepository;

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
