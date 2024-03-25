package com.ddu.ce.tournament.controller;


import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.service.imp.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class TeamContoller {

    @Autowired
    private TeamServiceImpl teamService;

    @PostMapping("/team")
    @PreAuthorize("hasRole('ADMIN')")
    public String createTeam(@RequestBody Team team) {
        System.out.println("TeamContoller.createTeam");
        teamService.save(team);
        return "Team saved";
    }

    @GetMapping("/team/{id}")
    public Team findTeam(@PathVariable int id) {
        System.out.println("TeamContoller.findTeam");
        return teamService.findById(id);
    }

    @DeleteMapping("/team/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteTeam(@PathVariable int id) {
        System.out.println("TeamContoller.deleteTeam");
        teamService.deleteById(id);
        return "Team deleted";
    }

    @GetMapping("/teams")
    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<Team> findAllTeams() {
        System.out.println("TeamContoller.findAllTeams");
        return teamService.findAll();
    }

    @PutMapping("/team")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateTeam(@RequestBody Team team) {
        System.out.println("TeamContoller.updateTeam");
        teamService.save(team);
        return "Team updated";
    }

    @GetMapping("team/{team_id}/addplayer/{player_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String addPlayerToTeam(@PathVariable int team_id, @PathVariable int player_id) {

        teamService.addPlayerToTeam(team_id, player_id);
        return "Player added to team";
    }

    @GetMapping("team/{team_id}/players")
    public List<Player> getPlayers(@PathVariable int team_id) {

        return teamService.getPlayers(team_id);
    }


    @DeleteMapping("/delete/team/{team_id}/deleteplayer/{player_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deletePlayerFromTeam(@PathVariable int team_id, @PathVariable int player_id) {
        teamService.deletePlayerFromTeam(team_id, player_id);
        return "Player deleted from team";
    }

}
