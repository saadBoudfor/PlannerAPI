package fr.home.app.planner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class App implements CommandLineRunner{

    private JpaUserRepository userRepository;
    private JpaAddressRepository addressRepository;

    public App(JpaUserRepository jpaUserRepository, JpaAddressRepository addressRepository){
        this.userRepository = jpaUserRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Address address = Address.builder()
                .street("7 rue des amaryllis")
                .complement("Logement 213, batiment 5")
                .postalZip(34070)
                .city("Montpellier")
                .country("France")
                .type(AddressType.MAIN)
                .build();
        addressRepository.save(address);

        List<Address> addressList = new ArrayList<>();
        addressList.add(address);

        User user = User.builder()
                .email("saad.boudfor@capgemini.com")
                .firstName("saad")
                .lastName("boudfor")
                .addressList(addressList)
                .build();

        userRepository.save(user);
  }
}
