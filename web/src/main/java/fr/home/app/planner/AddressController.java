package fr.home.app.planner;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private JpaAddressRepository addressRepository;

    public AddressController(JpaAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/")
    public List<Address> getAllAddress() {
        return this.addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address getAddress(@PathVariable("{id}") long addressId) {
        return addressRepository.findOne(addressId);
    }

    @PostMapping
    public Address newAddress(@RequestBody Address address) {
        Address savedAddress = addressRepository.save(address);
        return addressRepository.findOne(savedAddress.getId());
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address) {
        Address savedAddress = addressRepository.save(address);
        return addressRepository.findOne(savedAddress.getId());
    }

    @PostMapping
    public Long deleteAddress(@RequestBody Address address) {
        addressRepository.delete(address);
        return address.getId();
    }

}
