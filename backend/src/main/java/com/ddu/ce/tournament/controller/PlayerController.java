package com.ddu.ce.tournament.controller;

import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.service.PlayerService;
import com.ddu.ce.tournament.service.imp.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*"  )
public class PlayerController {
    @Autowired
    private PlayerServiceImpl playerService;

    @PostMapping("/player")
    @PreAuthorize("hasRole('ADMIN')")
    public void createPlayer(@RequestBody Player player) {
        System.out.println("PlayerController.createPlayer");
        playerService.save(player);
    }

    @GetMapping("/player/{id}")
    public Player findPlayer(@PathVariable int id) {
        System.out.println("PlayerController.findPlayer");
        return playerService.findById(id);
    }

    @DeleteMapping("/player/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deletePlayer(@PathVariable int id) {
        System.out.println("PlayerController.deletePlayer");
        playerService.deleteById(id);
    }

    @GetMapping("/players")
    public Iterable<Player> findAllPlayers() {
        System.out.println("PlayerController.findAllPlayers");
        return playerService.findAll();
    }

    @PutMapping("/player")
    @PreAuthorize("hasRole('ADMIN')")
    public void updatePlayer(@RequestBody Player player) {
        System.out.println("PlayerController.updatePlayer");
        playerService.save(player);
    }

}
