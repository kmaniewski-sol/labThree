package exercise.jpamvc.service;

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

    public Orders save(Orders orders){
        return ordersRepository.save(orders);
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

    public List<Object[]> getShipmentDetails(Long id) {
        return ordersRepository.getShipmentDetails(id);
    }

}
