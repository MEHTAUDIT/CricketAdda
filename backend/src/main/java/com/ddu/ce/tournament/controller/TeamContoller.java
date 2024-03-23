package com.ddu.ce.tournament.controller;


import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.service.imp.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*"  )
public class TeamContoller {

    @Autowired
    private TeamServiceImpl teamService;

    @PostMapping("/team")
    public void createTeam(@RequestBody Team team) {
        System.out.println("TeamContoller.createTeam");
        teamService.save(team);
    }

    @GetMapping("/team/{id}")
    public Team findTeam(@PathVariable int id) {
        System.out.println("TeamContoller.findTeam");
        return teamService.findById(id);
    }

    @DeleteMapping("/team/{id}")
    public void deleteTeam(@PathVariable int id) {
        System.out.println("TeamContoller.deleteTeam");
        teamService.deleteById(id);
    }

    @GetMapping("/teams")
    public Iterable<Team> findAllTeams() {
        System.out.println("TeamContoller.findAllTeams");
        return teamService.findAll();
    }

    @PutMapping("/team")
    public void updateTeam(@RequestBody Team team) {
        System.out.println("TeamContoller.updateTeam");
        teamService.save(team);
    }

    @GetMapping("team/{team_id}/addplayer/{player_id}")
    public void addPlayerToTeam(@PathVariable int team_id, @PathVariable int player_id) {

        teamService.addPlayerToTeam(team_id, player_id);
    }

    @GetMapping("team/{team_id}/players")
    public List<Player> getPlayers(@PathVariable int team_id) {

        List<Player> players = teamService.getPlayers(team_id);
        return players;
    }



}
