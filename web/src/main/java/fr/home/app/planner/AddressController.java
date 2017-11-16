package fr.home.app.planner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController  {
    private JpaAddressRepository addressRepository;

    public AddressController(JpaAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/all")
    public List<Address> getAllAddress(){
        return this.addressRepository.findAll();
    }
}
