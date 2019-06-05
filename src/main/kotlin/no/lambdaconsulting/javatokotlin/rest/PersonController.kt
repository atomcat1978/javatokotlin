package no.lambdaconsulting.javatokotlin.rest

import no.lambdaconsulting.javatokotlin.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(produces = ["application/json;charset=UTF-8"])
class PersonController(val service: PersonService) {

    @GetMapping
    fun listPersons() = ResponseEntity.ok(service.findAll())


    @GetMapping("person/{personId}")
    fun person(@PathVariable("personId") personId : Int) = ResponseEntity.ok(service.getDetails(personId))

}