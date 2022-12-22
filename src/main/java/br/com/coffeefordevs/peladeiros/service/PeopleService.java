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
        List<PeopleDTO> dto = new ArrayList<>();
        for(PeopleEntity people : findAllPeople()) {
            dto.add(new PeopleDTO(
                    people.getName(),
                    people.getLastName(),
                    people.getPhone()
            ));
        }
        return dto;
    }

    private PeopleEntity insertPeople(String name, String lastName, String phone) {
        return peopleRepository.save(new PeopleEntity(
                name,
                lastName,
                phone
        ));
    }

    public Iterable<PeopleEntity> findAllPeople() {
        Iterable<PeopleEntity> peoples = peopleRepository.findAll();
        return peoples;
    }

    public PeopleDTO insertPeopleDTO(PeopleDTO peopleDTO) {
        if(peopleDTO != null) {
            PeopleEntity peopleEntity = insertPeople(peopleDTO.getName(), peopleDTO.getLastName(), peopleDTO.getPhone());
            return new PeopleDTO(
                    peopleEntity.getName(),
                    peopleEntity.getLastName(),
                    peopleEntity.getPhone()
            );
        }
        return null;
    }
}
