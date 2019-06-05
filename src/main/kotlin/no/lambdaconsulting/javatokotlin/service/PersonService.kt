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

    /* FIX> Made a bit more fluent and easier to read. */
    fun getDetails(id: Int): PersonDetails? = personDao.getById(id)?.let { personSummary ->
        PersonDetails(
            id,
            personSummary.firstName,
            personSummary.lastName,
            petDao.findByPerson(id)
        )
    }
}