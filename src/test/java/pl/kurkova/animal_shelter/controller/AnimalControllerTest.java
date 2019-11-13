package pl.kurkova.animal_shelter.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.kurkova.animal_shelter.domain.Animal;
import pl.kurkova.animal_shelter.service.DbService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnimalController.class)
public class AnimalControllerTest {
    Animal animal = new Animal("8dcc4a74c67b3e57acb88991","Jorgy", "pitbull", "dog");

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService service;

    @Test
    public void shouldFetchEmptyAnimalsList() throws Exception {
        //Given
        List<Animal> animalsList = new ArrayList<>();
        when(service.getAllAnimals()).thenReturn(animalsList);
        //When & Then
        mockMvc.perform(get("/v1/animals").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchAnimalsList() throws Exception {
        //Given
        List<Animal> animalsList = new ArrayList<>();
        animalsList.add(animal);
        when(service.getAllAnimals()).thenReturn(animalsList);
        //When&Then
        mockMvc.perform(get("/v1/animals").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is("8dcc4a74c67b3e57acb88991")))
                .andExpect(jsonPath("$[0].name", is("Jorgy")))
                .andExpect(jsonPath("$[0].species", is("pitbull")))
                .andExpect(jsonPath("$[0].breed", is("dog")));


    }
}
