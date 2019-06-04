package no.lambdaconsulting.javatokotlin.domain;

public class PersonSummary {

    public final Integer id;
    public final String firstName;
    public final String lastName;

    public PersonSummary(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}