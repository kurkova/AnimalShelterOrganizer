package pl.kurkova.animal_shelter.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kurkova.animal_shelter.domain.Animal;

import java.util.List;

public interface AnimalRepository extends MongoRepository <Animal, String> {

    Animal findById(ObjectId _id);

    Animal findByName (String name);

    @Override
    List<Animal> findAll();
}
