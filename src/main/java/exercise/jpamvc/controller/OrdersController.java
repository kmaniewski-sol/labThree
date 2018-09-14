package exercise.jpamvc.controller;

import exercise.jpamvc.domain.*;
import exercise.jpamvc.service.OrdersService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {

    private OrdersService ordersService;

    OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
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
        Address address = ordersService.getOrderAddress(number);
        OrderLineItem orderLineItems = ordersService.getOrderLineItems(number);
        OrderDetailsQuery orderDetailsQuery = null;
        for(Object o[]: result){
            orderDetailsQuery = new OrderDetailsQuery((String) o[0], address.toString() , (Double) o[1], (String) o[2], orderLineItems.getId());
        }
        return orderDetailsQuery;
    }

    @GetMapping(path="/shipments/account/{number}")
    public List<ShipmentDetailQuery> getShipments(@PathVariable("number") Long id) {
        List<String> orderNumbers =  ordersService.getOrderNumber(id);
        List<OrderLineItem> orderLineItems = ordersService.getShipmentsOrderLineItem(id);
        List<ShipmentDetailQuery> shipmentDetailQueries = new ArrayList<>();
        for(int i = 0; i < orderNumbers.size(); i++){
            Product product = orderLineItems.get(i).getProduct();
            Shipment shipment = orderLineItems.get(i).getShipment();
            ShipmentDetailQuery shipmentDetailQuery = new ShipmentDetailQuery(orderNumbers.get(i), shipment.getShippedDate(), shipment.getDeliveryDate(), product.getName(), orderLineItems.get(i).getQuantity());
            shipmentDetailQueries.add(shipmentDetailQuery);
        }
        return shipmentDetailQueries;
    }
}
