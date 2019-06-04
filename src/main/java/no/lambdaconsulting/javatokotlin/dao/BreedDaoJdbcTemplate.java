package no.lambdaconsulting.javatokotlin.dao;

import no.lambdaconsulting.javatokotlin.domain.Breed;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BreedDaoJdbcTemplate implements BreedDao {

    private final JdbcTemplate jdbcTemplate;

    public BreedDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Breed getById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT id, name FROM breed WHERE id = ?",
                new Object[]{id},
                (res, rowNum) ->
                        new Breed(
                                res.getInt("id"),
                                res.getString("name")
                        )
        );
    }
}