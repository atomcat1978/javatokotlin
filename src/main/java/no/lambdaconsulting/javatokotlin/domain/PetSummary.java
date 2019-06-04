package no.lambdaconsulting.javatokotlin.domain;

public class PetSummary {

    public final Integer id;
    public final String name;
    public final Integer breedId;

    public PetSummary(Integer id, String name, Integer breedId) {
        this.id = id;
        this.name = name;
        this.breedId = breedId;
    }
}