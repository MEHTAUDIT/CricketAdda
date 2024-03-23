package com.ddu.ce.tournament.controller;

import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.Tournament;
import com.ddu.ce.tournament.service.imp.PlayerServiceImpl;
import com.ddu.ce.tournament.service.imp.TournamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TournamentCotroller {

    @Autowired
    private TournamentServiceImpl tournamentService;

    @PostMapping("/tournament")
    public void createTournament(@RequestBody Tournament tournament) {
        System.out.println("TournamentCotroller.createTournament");
        tournamentService.save(tournament);
    }

    @GetMapping("/tournament/{id}")
    public Tournament findTournament(@PathVariable int id) {
        System.out.println("TournamentCotroller.findTournament");
        return tournamentService.findById(id);
    }

    @DeleteMapping("/tournament/delete/{id}")
    public void deleteTournament(@PathVariable int id) {
        System.out.println("TournamentCotroller.deleteTournament");
        tournamentService.deleteById(id);
    }

    @GetMapping("/tournaments")
    public Iterable<Tournament> findAllTournaments() {
        System.out.println("TournamentCotroller.findAllTournaments");
        return tournamentService.findAll();
    }

    @PutMapping("/tournament")
    public void updateTournament(@RequestBody Tournament tournament) {
        System.out.println("TournamentCotroller.updateTournament");
        tournamentService.save(tournament);
    }

    @GetMapping("/tournament/addteam/{tournament_id}/{team_id}")
    public void addTeamToTournament(@PathVariable int tournament_id, @PathVariable int team_id) {
        System.out.println("TournamentCotroller.addTeamToTournament");
        tournamentService.addTeamToTournament(tournament_id, team_id);
    }

    @GetMapping("/tournament/teams/{tournament_id}")
    public List<Team> getTeams(@PathVariable int tournament_id) {

        List<Team> teams = tournamentService.getTeams(tournament_id);
//        for (Team team : teams) {
//            System.out.println("from controller " + team.getTeam_name());
//        }
        return teams;
    }

}
