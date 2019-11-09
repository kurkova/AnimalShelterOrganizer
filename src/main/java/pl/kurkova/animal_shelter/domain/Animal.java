package pl.kurkova.animal_shelter.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Animal {
    @Id
    public ObjectId _id;

    public String name;
    public String species;
    public String breed;
}
