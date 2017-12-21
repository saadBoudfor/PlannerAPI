package fr.home.app.planner;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class App implements CommandLineRunner {

    private UserRepository userRepository;
    private JpaAddressRepository addressRepository;
    private RolesRepository rolesRepository;

    @Override
    public void run(String... strings) throws Exception {
        Role userRole = Role.builder().name("USER").description("restrictive access to planner app").build();
        Role adminRole = Role.builder().name("ADMIN").description("full access to planner app").build();

        rolesRepository.save(adminRole);
        rolesRepository.save(userRole);
        List<Role> roles = new ArrayList<>();
        List<Role> roles1 = new ArrayList<>();

        roles.add(adminRole);
        roles1.add(userRole);

        Address address = Address.builder()
                .street("7 rue des amaryllis")
                .complement("Logement 213, batiment 5")
                .postalZip(34070)
                .city("Montpellier")
                .country("France")
                .type(AddressType.MAIN)
                .name("Domicile")
                .build();

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);

        addressRepository.save(address);

        User user = User.builder()
                .email("saad.boudfor@capgemini.com")
                .firstName("saad")
                .lastName("boudfor")
                .addressList(addressList)
                .roles(roles)
                .username("sboudfor")
                .password("123")
                .enabled(true)
                .build();

        userRepository.save(user);


        User user2 = User.builder()
                .email("hajar.boudfor@capgemini.com")
                .firstName("hajar")
                .lastName("boudfor")
                .addressList(addressList)
                .roles(roles1)
                .username("hboudfor")
                .password("456")
                .enabled(true)
                .build();

        userRepository.save(user2);


    }
}
