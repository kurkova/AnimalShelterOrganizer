package pl.kurkova.animal_shelter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kurkova.animal_shelter.domain.Animal;
import pl.kurkova.animal_shelter.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DbService {

    @Autowired
    private AnimalRepository repository;

    public Optional<Animal>  getAnimalById(final String id){
        return repository.findById(id);
    }

    public List<Animal> getAllAnimals(){
        return repository.findAll();
    }
}
