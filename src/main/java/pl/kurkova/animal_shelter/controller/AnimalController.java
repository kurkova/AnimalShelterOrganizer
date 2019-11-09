package pl.kurkova.animal_shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kurkova.animal_shelter.domain.Animal;
import pl.kurkova.animal_shelter.service.DbService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class AnimalController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "/animals")
    public List<Animal>  getAnimals (){
        return service.getAllAnimals();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/animal/{animalId}")
    public Optional<Animal> getAnimalById(@RequestParam String id)  {
        return service.getAnimalById(id);
    }
}
