package br.com.coffeefordevs.peladeiros.controller;

import br.com.coffeefordevs.peladeiros.dto.PeopleDTO;
import br.com.coffeefordevs.peladeiros.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(PeopleController.PATH)
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    public static final String PATH = "/api/people";

    @GetMapping(produces = {"application/json"})
    private ResponseEntity<List<PeopleDTO>> getAllPeople() {
        List<PeopleDTO> peopleDTOList = peopleService.findAllPeopleDTO();
        if (peopleDTOList != null) {
            if(peopleDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.ok(peopleDTOList);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
