package load.management.repositories;

import load.management.entities.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrierRepository extends JpaRepository<Carrier,Integer> {
}
