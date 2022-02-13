package com.erendarici.api;

import com.erendarici.entity.Person;
import com.erendarici.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostConstruct
    public void init() {
        Person person = new Person();
        person.setFirstname("Eren");
        person.setLastname("Darici but the second");
        person.setAddress("Eskişehir");
        person.setBirthdate(Calendar.getInstance().getTime());
        personRepository.save(person);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable String search) {
        List<Person> people = personRepository.findByFirstnameLikeOrLastnameLike(search, search);
        return ResponseEntity.ok(people);

    }
}
