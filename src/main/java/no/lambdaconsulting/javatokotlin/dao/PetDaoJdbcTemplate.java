package no.lambdaconsulting.javatokotlin.dao;

import no.lambdaconsulting.javatokotlin.domain.PetSummary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetDaoJdbcTemplate implements PetDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<PetSummary> rowMapper = (res, rowNum) ->
        new PetSummary(
            res.getInt("id"),
            res.getString("name"),
            res.getInt("breed_id")
        );

    public PetDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PetSummary> findByPerson(int personId) {
        return jdbcTemplate.query(
            "SELECT id, name, breed_id FROM pet where person_id = ?",
            new Object[]{personId},
            rowMapper
        );
    }

    @Override
    public PetSummary getById(int petId) {
        return jdbcTemplate.queryForObject(
            "SELECT id, name, breed_id FROM pet WHERE id = ?",
            new Object[]{petId},
            rowMapper
        );
    }
}