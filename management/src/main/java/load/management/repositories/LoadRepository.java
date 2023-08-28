package load.management.repositories;

import load.management.entities.Carrier;
import load.management.entities.Load;
import load.management.entities.Shipper;
import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoadRepository extends JpaRepository<Load,Integer> {
    List<Load> findByShipperid(int id);


    @Query(value = "select l.shipperid from load l where l.carrierid = :lid",nativeQuery = true)
    List<Integer> getShipperList(@Param("lid") int lid);

    @Query(value = "select * from load where carrierid = :id",nativeQuery = true)
    List<Load> getCarrierLoad(@Param("id") int id);

}