package no.lambdaconsulting.javatokotlin.dao

import no.lambdaconsulting.javatokotlin.domain.PersonSummary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet

/* FIX> Moved interface and implementing jdbc template in same file  */
interface PersonDao {
    fun findAll(): List<PersonSummary>
    fun getById(id: Int): PersonSummary?
}

@Repository
class PersonDaoJdbcTemplate(private val jdbcTemplate: JdbcTemplate) : PersonDao {

    /* FIX> Replaced unused rowNumber with _ - stands for unused lambda parameters - listen to the IDE, it warns  */
    private val rowMapper: (ResultSet, Int) -> PersonSummary = { res, _ ->
        PersonSummary(
            res.getInt("id"),
            res.getString("first_name"),
            res.getString("last_name")
        )
    }

    /* FIX> Converted to single-expression function  */
    override fun findAll(): List<PersonSummary> = jdbcTemplate.query(
        "SELECT id, first_name, last_name FROM person",
        rowMapper
    )

    /* FIX> Converted to single-expression function  */
    override fun getById(id: Int): PersonSummary? = jdbcTemplate.queryForObject(
        "SELECT id, first_name, last_name FROM person where id = ?",
        arrayOf<Any>(id),
        rowMapper
    )
}