package load.management.controllers;

import load.management.entities.Load;
import load.management.entities.Shipper;
import load.management.repositories.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class LoadController {
    @Autowired
    private LoadRepository loadRepository;

    @GetMapping("/load")
    public List<Load> getAllLoads(){
        return loadRepository.findAll();
    }

    @PostMapping("/load/add")
    public Load addNewLoad(@RequestBody Load load) throws Exception{
        var b =loadRepository.save(load);
        return b;
    }

    @PutMapping("/load/id/weight")
    public Load updateWeight(@RequestParam("id") int id,@RequestParam("weight") int weight) throws Exception{
        var a = loadRepository.findById(id).get();
        if(a!=null){
            a.setWeight(weight);
            return a;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given Id is not present");
        }
    }

    @DeleteMapping("/deleteLoad/id")
    public void deleteLoad(@RequestParam("id") int id) throws Exception{
        var a = loadRepository.findById(id).get();
        if(a!=null){
            loadRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given id is not found");
        }
    }

    @GetMapping("/carrier/{id}")
    public List<Integer> getShipperForCarrier(@PathVariable("id") int id) throws Exception{
        var a = loadRepository.getShipperList(id);
        if(a != null){
            return a;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No Shipper is available or no carrier with given id");
        }
    }

    @GetMapping("/load/{carrierid}")
    public List<Load> getLoadsByCarrier(@PathVariable("carrierid") int id){
        return loadRepository.getCarrierLoad(id);

    }
}
