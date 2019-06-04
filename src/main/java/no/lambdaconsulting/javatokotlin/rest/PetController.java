package no.lambdaconsulting.javatokotlin.rest;

import no.lambdaconsulting.javatokotlin.domain.PetDetails;
import no.lambdaconsulting.javatokotlin.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping(path = "{petId}", produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<PetDetails> getPet(@PathVariable("petId") Integer petId) {
        return ResponseEntity.ok(petService.getDetails(petId));
    }
}