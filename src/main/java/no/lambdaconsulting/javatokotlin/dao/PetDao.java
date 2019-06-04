package no.lambdaconsulting.javatokotlin.dao;

import no.lambdaconsulting.javatokotlin.domain.PetSummary;

import java.util.List;

public interface PetDao {
    List<PetSummary> findByPerson(int personId);
    PetSummary getById(int petId);
}