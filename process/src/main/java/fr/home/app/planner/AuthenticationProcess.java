package fr.home.app.planner;

import fr.home.app.planner.views.UserView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@Component
class AuthenticationProcess implements IAuthenticationProcess {

    private JwtUserRepository jwtUserRepository;
    private JpaAddressRepository addressRepository;
    private UserRepository userRepository;
    private static final String DEFAULT_ROLE = "USER";

    public void createAccount(UserView userView) {

        JwtUser jwtUser = JwtUser.builder()
                .userName(userView.getUsername())
                .password(userView.getPassword())
                .role(DEFAULT_ROLE)
                .build();
        jwtUserRepository.save(jwtUser);

        Address address = Address.builder()
                .city(userView.getCity())
                .complement(userView.getComplement())
                .country(userView.getCountry())
                .name(userView.getAddressName())
                .street(userView.getStreet())
                .type(AddressType.MAIN)
                .build();

        addressRepository.save(address);

        Collection<Address> addresses = new ArrayList<>();
        addresses.add(address);

        User user = User.builder()
                .firstName(userView.getFirstName())
                .lastName(userView.getLastName())
                .email(userView.getEmail())
                .jwtUser(jwtUser)
                .addressList(addresses)
                .build();

        userRepository.save(user);
    }
}
