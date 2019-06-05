package no.lambdaconsulting.javatokotlin.domain

data class PersonDetails(val id: Int, val firstName: String, val lastName: String, val pets: List<PetSummary>)
data class PetDetails(val id: Int, val name: String, val breed: Breed?)
