package no.lambdaconsulting.javatokotlin.service

import no.lambdaconsulting.javatokotlin.dao.PersonDao
import no.lambdaconsulting.javatokotlin.dao.PetDao
import no.lambdaconsulting.javatokotlin.domain.PersonDetails
import no.lambdaconsulting.javatokotlin.domain.PersonSummary
import org.springframework.stereotype.Service

@Service
class PersonService(private val personDao: PersonDao, private val petDao: PetDao) {

    fun findAll(): List<PersonSummary> {
        return personDao.findAll()
    }

    fun getDetails(id: Int): PersonDetails {
        val personSummary = personDao.getById(id)
        val petSummaries = petDao.findByPerson(id)
        return PersonDetails(
                id,
                personSummary.firstName,
                personSummary.lastName,
                petSummaries
        )
    }
}