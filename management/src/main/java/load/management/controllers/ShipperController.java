package load.management.controllers;

import load.management.entities.Load;
import load.management.entities.Shipper;
import load.management.repositories.LoadRepository;
import load.management.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ShipperController {
    @Autowired
    private ShipperRepository shipperRepository;

    @Autowired
    private LoadRepository loadRepository;

    @GetMapping("/shipper")
    public List<Shipper> getAllShippers(){
        return shipperRepository.findAll();
    }

    @GetMapping("/shipper/{id}")
    public List<Load> getLoadsForShipper(@PathVariable("id") int id){
        var v = loadRepository.findByShipperid(id);
        return v;
    }

   @PostMapping("/shipper/add")
    public Shipper addNewShipper(@RequestBody Shipper shipper) throws Exception{

        var a = shipperRepository.save(shipper);
        return a;

   }

   @PutMapping("/shipper/{id}/{location}")
    public Shipper updateShipper(@PathVariable("id") int id,@PathVariable("location") int location) throws Exception{
        var a = shipperRepository.findById(id).get();
        if(a != null) {
            a.setLocationB(location);
            return a;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given Id is not found");
        }
   }

   @DeleteMapping("/deleteShipper/id")
    public void deleteShipper(@RequestParam("id") int id) throws Exception{
        var a = shipperRepository.findById(id).get();
        if(a == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given Id is not present");
        }
        else{
            shipperRepository.deleteById(id);
        }
   }

}
