package no.lambdaconsulting.javatokotlin.dao;

import no.lambdaconsulting.javatokotlin.domain.PersonSummary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoJdbcTemplate implements PersonDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<PersonSummary> rowMapper = (res, rowNumber) ->
        new PersonSummary(
            res.getInt("id"),
            res.getString("first_name"),
            res.getString("last_name")
        );

    public PersonDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PersonSummary> findAll() {
        return jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM person",
            rowMapper
        );
    }

    @Override
    public PersonSummary getById(int id) {
        return jdbcTemplate.queryForObject(
            "SELECT id, first_name, last_name FROM person where id = ?",
            new Object[]{id},
            rowMapper
        );
    }
}