package com.ddu.ce.tournament.controller;

import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.Tournament;
import com.ddu.ce.tournament.payload.request.MatchRequest;
import com.ddu.ce.tournament.service.imp.PlayerServiceImpl;
import com.ddu.ce.tournament.service.imp.TournamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173"  )
public class TournamentCotroller {

    @Autowired
    private TournamentServiceImpl tournamentService;

    @PostMapping("/tournament")
    @PreAuthorize("hasRole('ADMIN')")
    public void createTournament(@RequestBody Tournament tournament) {
        System.out.println("TournamentCotroller.createTournament");
        tournamentService.save(tournament);
    }

    @GetMapping("/tournament/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public Tournament findTournament(@PathVariable int id) {
        System.out.println("TournamentCotroller.findTournament");
        return tournamentService.findById(id);
    }

    @DeleteMapping("/tournament/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTournament(@PathVariable int id) {
        System.out.println("TournamentCotroller.deleteTournament");
        tournamentService.deleteById(id);
    }

    @GetMapping("/tournaments")
//    @PreAuthorize("hasRole('ADMIN')")
    public Iterable<Tournament> findAllTournaments() {
        System.out.println("TournamentCotroller.findAllTournaments");
        return tournamentService.findAll();
    }

    @PutMapping("/tournament")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateTournament(@RequestBody Tournament tournament) {
        System.out.println("TournamentCotroller.updateTournament");
        tournamentService.save(tournament);
    }

    @GetMapping("/tournament/{tournament_id}/addteam/{team_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void addTeamToTournament(@PathVariable int tournament_id, @PathVariable int team_id) {
        System.out.println("TournamentCotroller.addTeamToTournament");
        tournamentService.addTeamToTournament(tournament_id, team_id);
    }

    @GetMapping("/tournament/{tournament_id}/teams")
    public List<Team> getTeams(@PathVariable int tournament_id) {

        List<Team> teams = tournamentService.getTeams(tournament_id);
//        for (Team team : teams) {
//            System.out.println("from controller " + team.getTeam_name());
//        }
        return teams;
    }

    @GetMapping("/tournament/{tournament_id}/matches")
    public List<Match> getMatches(@PathVariable int tournament_id) {
        System.out.println("TournamentCotroller.getMatches");
        return tournamentService.getMatches(tournament_id);
    }

    @PostMapping("/tournament/addmatch")
    @PreAuthorize("hasRole('ADMIN')")
    public void addMatchToTournament(@RequestBody MatchRequest request) {
        System.out.println("TournamentCotroller.addMatchToTournament");
        tournamentService.addMatchToTournament(request.getTournament_id(), request.getTeam1_id(), request.getTeam2_id() , request.getMatch_date() );
    }



    @PostMapping("/tournament/check")
    @PreAuthorize("hasRole('ADMIN')")
    public String check(@RequestBody String tournament_id) {
        return "tournament_id: " + tournament_id;
    }


}
