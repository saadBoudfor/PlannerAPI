package fr.home.app.planner;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private JpaUserRepository userRepository;

    public UserController(JpaUserRepository jpaUserRepository) {
        this.userRepository = jpaUserRepository;
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long userId) {
        return userRepository.findOne(userId);
    }
    @PostMapping
    public User loadUser(@RequestBody final User user) {
        userRepository.save(user);
        return userRepository.getOne(user.getId());
    }

    @PutMapping
    public User updateUser(@RequestBody final User user) {
        userRepository.save(user);
        return userRepository.getOne(user.getId());
    }

    @DeleteMapping("/{id}")
    public Long deleteUser(@PathVariable("id") Long userId) {
        userRepository.delete(userId);
        return userId;
    }

}
