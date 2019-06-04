package no.lambdaconsulting.javatokotlin.rest;

import no.lambdaconsulting.javatokotlin.domain.PersonDetails;
import no.lambdaconsulting.javatokotlin.domain.PersonSummary;
import no.lambdaconsulting.javatokotlin.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<PersonSummary>> listPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(path = "person/{personId}", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<PersonDetails> person(@PathVariable("personId") Integer personId) {
        return ResponseEntity.ok(personService.getDetails(personId));
    }
}