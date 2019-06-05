package no.lambdaconsulting.javatokotlin.domain

/* FIX> Moved all domain classes to one kotlin file, since the domain is not too complicated */
data class PersonDetails(val id: Int, val firstName: String, val lastName: String, val pets: List<PetSummary>)
data class PersonSummary(val id: Int, val firstName: String, val lastName: String)
data class PetDetails(val id: Int, val name: String, val breed: Breed?)
data class PetSummary(val id: Int, val name: String, val breedId: Int)
data class Breed(val id: Int, val name: String)
