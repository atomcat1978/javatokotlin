package no.lambdaconsulting.javatokotlin.dao
import no.lambdaconsulting.javatokotlin.domain.PersonSummary


interface PersonDao {
    fun findAll(): List<PersonSummary>
    fun getById(id: Int): PersonSummary?
}
