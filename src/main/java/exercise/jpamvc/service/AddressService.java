package exercise.jpamvc.service;

import exercise.jpamvc.domain.Address;
import exercise.jpamvc.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public Address retrieve(Long id) {
        return addressRepository.getById(id);
    }

    public void delete(Long id) {
        addressRepository.delete(id);
    }
}
