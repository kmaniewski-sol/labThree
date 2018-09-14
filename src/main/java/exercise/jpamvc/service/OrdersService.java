package exercise.jpamvc.service;

import exercise.jpamvc.domain.Address;
import exercise.jpamvc.domain.OrderLineItem;
import exercise.jpamvc.domain.Orders;
import exercise.jpamvc.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private OrdersRepository ordersRepository;

    OrdersService(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public Orders retrieve(Long id) {
        return ordersRepository.getById(id);
    }

    public void delete(Long id) {
        ordersRepository.delete(id);
    }

    public List<String> getAll(Long id) {
        return ordersRepository.getAll(id);
    }

    public List<Object[]> getDetails(String orderNum) {
        return ordersRepository.getOrderDetails(orderNum);
    }

    public Address getOrderAddress(String orderNum) { return ordersRepository.getOrderAddress(orderNum); }

    public OrderLineItem getOrderLineItems(String orderNum) { return ordersRepository.getOrderLineItems(orderNum); }

    public List<String> getOrderNumber(Long id) {
        return ordersRepository.getOrderNumber(id);
    }

    public List<OrderLineItem> getShipmentsOrderLineItem(Long id) {
        return ordersRepository.getShipmentsOrderLineItems(id);
    }


}
