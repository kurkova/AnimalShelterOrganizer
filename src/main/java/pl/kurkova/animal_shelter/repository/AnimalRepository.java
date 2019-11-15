package pl.kurkova.animal_shelter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.kurkova.animal_shelter.domain.Animal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends MongoRepository <Animal, String> {

    Optional<Animal> findById(String id);

    @Override
    List<Animal> findAll();

    @Override
    Animal save (Animal animal);

    void deleteById (String id);

}

