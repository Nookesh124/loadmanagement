package load.management.controllers;

import load.management.entities.Location;
import load.management.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/location")
    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    @PostMapping("/location/add")
    public Location addNewLocation(@RequestBody Location location) throws Exception{

        var b = locationRepository.save(location);
        return b;
    }

    @PutMapping("/location/{id}/{city}")
    public Location updateLocation(@PathVariable("id") int id,@PathVariable("city") String city) throws Exception{
        var a = locationRepository.findById(id).get();
        if(a != null){
            if(city != null){
                a.setCity(city);
                return a;
            }
            else {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Null values not acceptable");
            }
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given Id is not present");
        }
    }

    @DeleteMapping("/deleteLocation/{id}")
    public void deleteLocation(@PathVariable("id") int id) throws Exception{
        var a = locationRepository.findById(id).get();
        if(a != null){
            locationRepository.deleteById(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Given id is not present");
        }
    }
}
