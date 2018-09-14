package exercise.jpamvc.controller;

import exercise.jpamvc.domain.Address;
import exercise.jpamvc.service.AddressService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    private AddressService addressService;

    AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping(path="/address/create")
    @ResponseBody
    public Address save(@RequestBody Address orders){
        return addressService.save(orders);
    };
    @GetMapping(path="/address/retrieve/{id}")
    public Address retrieve(@PathVariable("id") Long id){
        return addressService.retrieve(id);
    }

    @DeleteMapping(path="/address/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        addressService.delete(id);
    }
}
