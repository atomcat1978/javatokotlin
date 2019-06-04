package no.lambdaconsulting.javatokotlin.dao;

import no.lambdaconsulting.javatokotlin.domain.PersonSummary;

import java.util.List;

public interface PersonDao {
    List<PersonSummary> findAll();
    PersonSummary getById(int id);
}