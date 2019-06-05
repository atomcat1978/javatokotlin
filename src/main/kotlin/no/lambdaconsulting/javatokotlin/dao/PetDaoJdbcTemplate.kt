package no.lambdaconsulting.javatokotlin.dao

import no.lambdaconsulting.javatokotlin.domain.PetSummary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

interface PetDao {
    fun getById(petId: Int): PetSummary?
    fun findByPerson(personId: Int): List<PetSummary>
}

@Repository
class PetDaoJdbcTemplate(private val jdbcTemplate: JdbcTemplate) : PetDao {

    override fun getById(petId: Int): PetSummary? =
        /* FIX> 2nd param had to be be added, otherwise the SQL statement had no value for the placeholder */
        jdbcTemplate.queryForObject("SELECT id, name, breed_id FROM pet WHERE id = ?",
            arrayOf(petId)) { rs, _ ->
            PetSummary(rs.getInt("id"), rs.getString("name"), rs.getInt("breed_id"))
        }

    override fun findByPerson(personId: Int): List<PetSummary> =
        /* FIX> 2nd param had to be be added, otherwise the SQL statement had no value for the placeholder */
        jdbcTemplate.query("SELECT id, name, breed_id FROM pet where person_id = ?",
            arrayOf(personId)) { rs, _ ->
            PetSummary(rs.getInt("id"), rs.getString("name"), rs.getInt("breed_id"))
        }
}