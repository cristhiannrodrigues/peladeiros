package br.com.coffeefordevs.peladeiros.service;

import br.com.coffeefordevs.peladeiros.dto.PlayerDTO;
import br.com.coffeefordevs.peladeiros.entity.PlayerEntity;
import br.com.coffeefordevs.peladeiros.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerDTO> findAllPlayersDTO() {
        List<PlayerDTO> dto = new ArrayList<>();
        for(PlayerEntity player : findAllPlayers()) {
            dto.add( new PlayerDTO(
                    player.getId(),
                    player.getIdPeople(),
                    player.getInvited()
            ) );
        }
        return dto;
    }

    public Iterable<PlayerEntity> findAllPlayers() {
        return playerRepository.findAll();
    }

}
