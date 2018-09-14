package exercise.jpamvc.service;

import exercise.jpamvc.domain.OrderLineItem;
import exercise.jpamvc.repository.OrderLineItemRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderLineItemService {

    private OrderLineItemRepository orderLineItemRepository;

    OrderLineItemService(OrderLineItemRepository orderLineItemRepository){
        this.orderLineItemRepository = orderLineItemRepository;
    }

    public OrderLineItem save(OrderLineItem orderLineItem){
        return orderLineItemRepository.save(orderLineItem);
    }

    public OrderLineItem retrieve(Long id) {
        return orderLineItemRepository.getById(id);
    }

    public void delete(Long id) {
        orderLineItemRepository.delete(id);
    }
}
