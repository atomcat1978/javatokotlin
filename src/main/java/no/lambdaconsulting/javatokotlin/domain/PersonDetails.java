package no.lambdaconsulting.javatokotlin.domain;

import java.util.List;

public class PersonDetails {

    public final Integer id;
    public final String firstName;
    public final String lastName;
    public final List<PetSummary> pets;

    public PersonDetails(Integer id, String firstName, String lastName, List<PetSummary> pets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pets = pets;
    }
}