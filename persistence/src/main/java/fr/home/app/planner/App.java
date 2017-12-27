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
    private JwtUserRepository jwtUserRepository;

    @Override
    public void run(String... strings) throws Exception {

        JwtUser jwtUser1 = JwtUser.builder().userName("saad").password("123").build();
        JwtUser jwtUser2 = JwtUser.builder().userName("hajar").password("123").build();

        jwtUserRepository.save(jwtUser1);
        jwtUserRepository.save(jwtUser2);

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
                .password("123")
                .jwtUser(jwtUser1)
                .build();

        userRepository.save(user);


        User user2 = User.builder()
                .email("hajar.boudfor@capgemini.com")
                .firstName("hajar")
                .lastName("boudfor")
                .addressList(addressList)
                .password("456")
                .jwtUser(jwtUser2)
                .build();

        userRepository.save(user2);


    }
}
