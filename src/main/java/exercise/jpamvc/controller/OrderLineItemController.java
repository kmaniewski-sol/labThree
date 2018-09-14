package exercise.jpamvc.controller;

import exercise.jpamvc.domain.OrderLineItem;
import exercise.jpamvc.service.OrderLineItemService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderLineItemController {

    private OrderLineItemService orderLineItemService;

    OrderLineItemController(OrderLineItemService orderLineItemService){
        this.orderLineItemService = orderLineItemService;
    }

    @GetMapping(path="/orderlineitem/retrieve/{id}")
    public OrderLineItem retrieve(@PathVariable("id") Long id){
        return orderLineItemService.retrieve(id);
    }

    @DeleteMapping(path="/orderlineitem/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        orderLineItemService.delete(id);
    }
}
