package exercise.jpamvc.repository;

import exercise.jpamvc.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {


    Orders getById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Orders o where o.id = :id")
    void delete(@Param("id") Long id);

    @Query("SELECT ordernumber FROM Orders o WHERE o.account.id = :id ORDER BY o.orderDate DESC")
    List<String> getAll(@Param("id") Long id);

    @Query("SELECT ordernumber, totalPrice, orderLineItems.product.name, o.shippingAddress, o.orderLineItems  FROM Orders o WHERE o.ordernumber = :orderNum")
    List<Object[]> getOrderDetails(@Param("orderNum") String orderNum);

    @Query("SELECT ordernumber, orderLineItems FROM Orders o WHERE o.account.id = :id ORDER BY o.orderLineItems.shipment.deliveryDate DESC")
    List<Object[]> getShipmentDetails(@Param("id") Long id);
}
