package exercise.jpamvc.controller;

import exercise.jpamvc.domain.*;
import exercise.jpamvc.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {

    private OrdersService ordersService;

    OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @PostMapping(path="/orders/create")
    @ResponseBody
    public Orders save(@RequestBody Orders orders){
        return ordersService.save(orders);
    }

    @GetMapping(path="/orders/retrieve/{id}")
    public Orders retrieve(@PathVariable("id") Long id){
        return ordersService.retrieve(id);
    }

    @DeleteMapping(path="/orders/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        ordersService.delete(id);
    }

    @GetMapping(path="/orders/all/account/{account}")
    public List<String> getAll(@PathVariable("account") Long account){
        return ordersService.getAll(account);
    }

    @GetMapping(path="/orders/detail/{number}")
    public OrderDetailsQuery getOrderDetails(@PathVariable("number") String number) {
        List<Object[]> result =  ordersService.getDetails(number);
        for(Object o[]: result){
            Address address = (Address) o[3];
            OrderLineItem orderLineItems = (OrderLineItem) o[4];
            return new OrderDetailsQuery((String) o[0], address.toString() , (Double) o[1], (String) o[2], orderLineItems.getId());
        }
        return null;
    }

    @GetMapping(path="/shipments/account/{number}")
    public List<ShipmentDetailQuery> getShipments(@PathVariable("number") Long id) {
        List<Object[]> shipmentDetails =  ordersService.getShipmentDetails(id);
        List<ShipmentDetailQuery> shipmentDetailQueries = new ArrayList<>();
        for(Object o[]: shipmentDetails) {
            for (int i = 0; i < shipmentDetails.size(); i++) {
                OrderLineItem orderLineItem = (OrderLineItem) o[i+1];
                Product product = orderLineItem.getProduct();
                Shipment shipment = orderLineItem.getShipment();
                ShipmentDetailQuery shipmentDetailQuery = new ShipmentDetailQuery((String) o[i], shipment.getShippedDate(), shipment.getDeliveryDate(), product.getName(), orderLineItem.getQuantity());
                shipmentDetailQueries.add(shipmentDetailQuery);
                i++;
            }
        }
        return shipmentDetailQueries;
    }
}
