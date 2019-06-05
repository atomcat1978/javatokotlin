package no.lambdaconsulting.javatokotlin.dao

import no.lambdaconsulting.javatokotlin.domain.Breed
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

interface BreedDao {
    fun getById(id: Int): Breed?
}

@Repository
class BreedDaoJdbcTemplate(private val jdbcTemplate: JdbcTemplate) : BreedDao {

    /* FIX> Specified return type explicitly since it is a public API function of the component */
    override fun getById(id: Int): Breed? = jdbcTemplate.queryForObject(
        "SELECT id, name FROM breed WHERE id = ?",
        arrayOf(id)) { res, _ ->
            Breed(res.getInt("id"), res.getString("name"))
        }
}