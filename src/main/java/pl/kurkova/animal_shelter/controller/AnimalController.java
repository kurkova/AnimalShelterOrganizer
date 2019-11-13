package pl.kurkova.animal_shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public Optional<Animal> getAnimalById(@RequestParam String animalId) {
        return service.getAnimalById(animalId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/animals", consumes = APPLICATION_JSON_VALUE)
    public Animal createAnimal(Animal animal) {
        return service.saveAnimal(animal);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/animal/{animalId}")
    public void deleteAnimal(@RequestParam String animalId) throws AnimalNotFoundException {
        if (service.getAnimalById(animalId).isPresent()) {
            service.deleteAnimal(animalId);
        } else {
            throw new AnimalNotFoundException();
        }
    }
}


