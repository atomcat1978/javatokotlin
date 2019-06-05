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
            jdbcTemplate.queryForObject("SELECT id, name, breed_id FROM pet WHERE id = ?") { rs, _ ->
                PetSummary(rs.getInt("id"), rs.getString("name"), rs.getInt("breed_id"))
            }

    override fun findByPerson(personId: Int): List<PetSummary> =
            jdbcTemplate.query("SELECT id, name, breed_id FROM pet where person_id = ?") { rs, _ ->
                PetSummary(rs.getInt("id"), rs.getString("name"), rs.getInt("breed_id"))
            }
}