package pl.kurkova.animal_shelter.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import pl.kurkova.animal_shelter.domain.Animal;

public interface AnimalRepository extends MongoRepository <Animal, String> {
    Animal findBy(ObjectId _id);
}
