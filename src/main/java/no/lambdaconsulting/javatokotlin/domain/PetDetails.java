package no.lambdaconsulting.javatokotlin.domain;

public class PetDetails {

    public final Integer id;
    public final String name;
    public final Breed breed;

    public PetDetails(Integer id, String name, Breed breed) {
        this.id = id;
        this.name = name;
        this.breed = breed;
    }
}