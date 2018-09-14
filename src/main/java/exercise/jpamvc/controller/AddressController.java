package exercise.jpamvc.controller;

import exercise.jpamvc.domain.Address;
import exercise.jpamvc.service.AddressService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private AddressService addressService;

    AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping(path="/address/retrieve/{id}")
    public Address retrieve(@PathVariable("id") Long id){
        return addressService.retrieve(id);
    }

    @DeleteMapping(path="/address/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        addressService.delete(id);
    }
}
