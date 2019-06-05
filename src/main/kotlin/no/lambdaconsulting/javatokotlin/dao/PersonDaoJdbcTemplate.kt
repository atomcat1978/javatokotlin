package no.lambdaconsulting.javatokotlin.dao

import no.lambdaconsulting.javatokotlin.domain.PersonSummary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class PersonDaoJdbcTemplate(private val jdbcTemplate: JdbcTemplate) : PersonDao {

    private val rowMapper: (ResultSet, Int) -> PersonSummary = { res, rowNumber ->
        PersonSummary(
                res.getInt("id"),
                res.getString("first_name"),
                res.getString("last_name")
        )
    }

    override fun findAll(): List<PersonSummary> {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM person",
                rowMapper
        )
    }

    override fun getById(id: Int): PersonSummary? {
        return jdbcTemplate.queryForObject(
                "SELECT id, first_name, last_name FROM person where id = ?",
                arrayOf<Any>(id),
                rowMapper
        )
    }

}
