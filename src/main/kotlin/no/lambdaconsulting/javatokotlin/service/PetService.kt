package no.lambdaconsulting.javatokotlin.service

import no.lambdaconsulting.javatokotlin.dao.BreedDao
import no.lambdaconsulting.javatokotlin.dao.PetDao
import no.lambdaconsulting.javatokotlin.domain.PetDetails
import org.springframework.stereotype.Service

@Service
class PetService(private val petDao: PetDao, private val breedDao: BreedDao) {

    fun getDetails(id: Int) = petDao.getById(id)?.let { petSummary ->
        PetDetails(
            petSummary.id,
            petSummary.name,
            breedDao.getById(petSummary.breedId)
        )
    }
}