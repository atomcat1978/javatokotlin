package no.lambdaconsulting.javatokotlin.rest

import no.lambdaconsulting.javatokotlin.domain.PetDetails
import no.lambdaconsulting.javatokotlin.service.PetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/petkotlin")
class PetControllerKotlin(val petService : PetService) {

    @GetMapping(path = ["/{petId}"], produces = ["application/json;charset=UTF-8"])
    fun getPet(@PathVariable("petId") petId : Int) : ResponseEntity<PetDetails> = ResponseEntity.ok(petService.getDetails(petId))
}