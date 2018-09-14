package exercise.jpamvc.repository;

import exercise.jpamvc.domain.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Shipment getById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Shipment s where s.id = :id")
    void delete(@Param("id") Long id);

}
