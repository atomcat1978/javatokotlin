package no.lambdaconsulting.javatokotlin.service;

import no.lambdaconsulting.javatokotlin.dao.PersonDao;
import no.lambdaconsulting.javatokotlin.dao.PetDao;
import no.lambdaconsulting.javatokotlin.domain.PersonDetails;
import no.lambdaconsulting.javatokotlin.domain.PersonSummary;
import no.lambdaconsulting.javatokotlin.domain.PetSummary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;
    private final PetDao petDao;

    public PersonService(PersonDao personDao, PetDao petDao) {
        this.personDao = personDao;
        this.petDao = petDao;
    }

    public List<PersonSummary> findAll() {
        return personDao.findAll();
    }

    public PersonDetails getDetails(Integer id) {
        final PersonSummary personSummary = personDao.getById(id);
        final List<PetSummary> petSummaries = petDao.findByPerson(id);
        return new PersonDetails(
                id,
                personSummary.firstName,
                personSummary.lastName,
                petSummaries
        );
    }
}