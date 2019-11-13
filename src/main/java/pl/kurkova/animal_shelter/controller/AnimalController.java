package pl.kurkova.animal_shelter.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kurkova.animal_shelter.controller.exception.AnimalNotFoundException;
import pl.kurkova.animal_shelter.domain.Animal;
import pl.kurkova.animal_shelter.service.DbService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class AnimalController {

    @Autowired
    private DbService service;

    @RequestMapping(method = RequestMethod.GET, value = "/animals")
    public List<Animal> getAnimals() {
        return service.getAllAnimals();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/animal/{animalId}")
    public Optional<Animal> getAnimalById(@PathVariable ("animalId") String animalId) {
        return service.getAnimalById(animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/animals", consumes = APPLICATION_JSON_VALUE)
    public Animal createAnimal(@RequestBody Animal animal) {
        return service.saveAnimal(animal);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/animal/{animalId}")
    public void deleteAnimal(@PathVariable ("animalId") String animalId) throws AnimalNotFoundException {
        if (service.getAnimalById(animalId).isPresent()) {
            service.deleteAnimal(animalId);
        } else {
            throw new AnimalNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/animal/{animalId}")
    public Animal updateAnimal (@PathVariable("id") String id, @RequestBody Animal animal){
        animal.setId(id);
        return service.saveAnimal(animal);
    }
}


