package exercise.jpamvc.repository;

import exercise.jpamvc.domain.OrderLineItem;
import exercise.jpamvc.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem, Long> {

    OrderLineItem getById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM OrderLineItem o where o.id = :id")
    void delete(@Param("id") Long id);
}
