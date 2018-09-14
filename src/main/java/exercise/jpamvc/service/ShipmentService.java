package exercise.jpamvc.service;

import exercise.jpamvc.domain.Shipment;
import exercise.jpamvc.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipmentService {

    private ShipmentRepository shipmentRepository;

    ShipmentService(ShipmentRepository shipmentRepository){
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment save(Shipment shipment){
        return shipmentRepository.save(shipment);
    }

    public Shipment retrieve(Long id) {
        return shipmentRepository.getById(id);
    }

    public void delete(Long id) {
        shipmentRepository.delete(id);
    }
}
