package exercise.jpamvc.repository;

import exercise.jpamvc.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Address getById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Address a where a.id = :id")
    void delete(@Param("id") Long id);
}
