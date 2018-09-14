package exercise.jpamvc.controller;

import exercise.jpamvc.domain.Shipment;
import exercise.jpamvc.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShipmentController {

    private ShipmentService shipmentService;

    ShipmentController(ShipmentService shipmentService){
        this.shipmentService = shipmentService;
    }

    @PostMapping(path="/shipment/create")
    @ResponseBody
    public Shipment save(@RequestBody Shipment shipment){
        return shipmentService.save(shipment);
    }

    @GetMapping(path="/shipment/retrieve/{id}")
    public Shipment retrieve(@PathVariable("id") Long id){
        return shipmentService.retrieve(id);
    }

    @DeleteMapping(path="/shipment/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        shipmentService.delete(id);
    }
}
