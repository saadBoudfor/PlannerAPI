package fr.home.app.planner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class App implements CommandLineRunner{

    private JpaUserRepository userRepository;

    public App(JpaUserRepository jpaUserRepository){
        this.userRepository = jpaUserRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.userRepository.save(new User("saad", "boudfor", "sboudfor@gmail.com"));
        this.userRepository.save(new User("hajar", "boudfor", "hboudfor@gmail.com"));
        this.userRepository.save(new User("fadwa", "boudfor", "fboudfor@gmail.com"));
   }
}
