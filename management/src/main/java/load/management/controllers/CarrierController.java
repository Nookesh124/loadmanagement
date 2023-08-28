package load.management.controllers;

import load.management.entities.Carrier;
import load.management.repositories.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CarrierController {
    @Autowired
    private CarrierRepository carrierRepository;

    @GetMapping("/carrier")
    public List<Carrier> getAllCarriers(){
        return carrierRepository.findAll();
    }

    @PostMapping("/carrier/add")
    public Carrier addNewCarrier(@RequestBody Carrier carrier) throws Exception{

        var a = carrierRepository.save(carrier);
        return a;

    }

    @PutMapping("/updatecarrier")
    public Carrier updateContactInfo(@RequestParam("id") int id,@RequestParam("contactinfo") String contactInfo) throws Exception{
        var a = carrierRepository.findById(id).get();
        if(a != null){
            if(contactInfo != null){
                a.setContactInfo(contactInfo);
                return a;
            }
            else{
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Null values not acceptable");
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given Id is not present");
        }
    }

    @DeleteMapping("/deleteCarrier/id")
    public void deleteCarrier(@RequestParam("id") int id) throws Exception{
        var a = carrierRepository.findById(id).get();
        if(a != null){
            carrierRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given Id is not found");
        }
    }
}
