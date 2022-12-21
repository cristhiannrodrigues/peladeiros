package br.com.coffeefordevs.peladeiros.service;

import br.com.coffeefordevs.peladeiros.dto.PeopleDTO;
import br.com.coffeefordevs.peladeiros.entity.PeopleEntity;
import br.com.coffeefordevs.peladeiros.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public List<PeopleDTO> findAllPeopleDTO() {
        List<PeopleDTO> dto = null;
        Iterable<PeopleEntity> peopleEntities = peopleRepository.findAll();

        if(peopleEntities.iterator().hasNext()) {
            dto = new ArrayList<>();
            for(PeopleEntity people : peopleEntities) {
                dto.add(new PeopleDTO(
                        people.getId(),
                        people.getName(),
                        people.getLastName(),
                        people.getPhone()
                ));
            }
        }
        return dto;
    }

}
