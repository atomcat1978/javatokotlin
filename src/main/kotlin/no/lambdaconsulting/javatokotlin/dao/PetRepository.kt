package no.lambdaconsulting.javatokotlin.dao

import no.lambdaconsulting.javatokotlin.domain.PetSummary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

/* FIX> Renamed file to *Repository since it contains interface and implementing JDBC template in one  */
interface PetDao {
    fun getById(petId: Int): PetSummary?
    fun findByPerson(personId: Int): List<PetSummary>
}

@Repository
class PetDaoJdbcTemplate(private val jdbcTemplate: JdbcTemplate) : PetDao {

    /* FIX> 2nd param had to be be added, otherwise the SQL statement had no value for the placeholder */
    /* FIX> Changed code style - often easier to read a parameter list of more, than 3 items if they are moved to separate lines */
    override fun getById(petId: Int): PetSummary? = jdbcTemplate.queryForObject(
        "SELECT id, name, breed_id FROM pet WHERE id = ?",
        arrayOf(petId)) { rs, _ ->
            PetSummary(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("breed_id")
            )
        }

    /* FIX> 2nd param had to be be added, otherwise the SQL statement had no value for the placeholder */
    /* FIX> Changed code style - often easier to read a parameter list of more, than 3 items if they are moved to separate lines */
    override fun findByPerson(personId: Int): List<PetSummary> = jdbcTemplate.query(
        "SELECT id, name, breed_id FROM pet where person_id = ?",
        arrayOf(personId)) { rs, _ ->
            PetSummary(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("breed_id")
            )
        }
}