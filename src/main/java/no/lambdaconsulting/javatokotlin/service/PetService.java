package no.lambdaconsulting.javatokotlin.service;

import no.lambdaconsulting.javatokotlin.dao.BreedDao;
import no.lambdaconsulting.javatokotlin.dao.PetDao;
import no.lambdaconsulting.javatokotlin.domain.PetDetails;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetDao petDao;
    private final BreedDao breedDao;

    public PetService(PetDao petDao, BreedDao breedDao) {
        this.petDao = petDao;
        this.breedDao = breedDao;
    }

    public PetDetails getDetails(Integer id) {
        var petSummary = petDao.getById(id);
        var breed = breedDao.getById(petSummary.breedId);
        return new PetDetails(
                petSummary.id,
                petSummary.name,
                breed
        );
    }
}