package exercise.jpamvc.repository;

import exercise.jpamvc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p where p.id = :id")
    void delete(@Param("id") Long id);
}
