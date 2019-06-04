package no.lambdaconsulting.javatokotlin.dao;

import no.lambdaconsulting.javatokotlin.domain.Breed;

public interface BreedDao {
    Breed getById(int id);
}