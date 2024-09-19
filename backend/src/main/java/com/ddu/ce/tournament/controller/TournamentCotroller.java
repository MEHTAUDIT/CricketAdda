package com.ddu.ce.tournament.controller;

import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.Tournament;
import com.ddu.ce.tournament.payload.request.MatchRequest;
import com.ddu.ce.tournament.payload.request.TournamentRequest;
import com.ddu.ce.tournament.payload.response.TournamentInfoResponse;
import com.ddu.ce.tournament.service.imp.TournamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173"  )
public class TournamentCotroller {

    @Autowired
    private TournamentServiceImpl tournamentService;

    @PostMapping("/tournament")
    public String createTournament(@RequestBody TournamentRequest tournament) {
        System.out.println("TournamentController.createTournament");
        tournamentService.save(tournament);
        return "Tournament saved";
    }

    @GetMapping("/tournament/{id}")
    public ResponseEntity<?> findTournament(@PathVariable int id) {
//        System.out.println("TournamentController.findTournament");

        return  ResponseEntity.ok().body(new TournamentInfoResponse(tournamentService.findById(id)));
    }

    @DeleteMapping("/tournament/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteTournament(@PathVariable int id) {
        System.out.println("TournamentCotroller.deleteTournament");
        tournamentService.deleteById(id);
        return "Tournament deleted";
    }

    @GetMapping("/tournaments")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAllTournaments() {
        System.out.println("TournamentCotroller.findAllTournaments");
        List<Tournament> tournaments = tournamentService.findAll();

        List<TournamentInfoResponse> tournamentInfoResponses = tournaments.stream().map(TournamentInfoResponse::new).collect(Collectors.toList());
//        for (TournamentInfoResponse tournamentInfoResponse : tournamentInfoResponses) {
//            System.out.println(tournamentInfoResponse);
//        }
        return ResponseEntity.ok().body(tournamentInfoResponses);
    }

    @PutMapping("/tournament")
    public String updateTournament(@RequestBody Tournament tournament) {
        System.out.println("TournamentCotroller.updateTournament");
        tournamentService.update(tournament);
        return "Tournament updated";
    }

    @GetMapping("/tournament/{tournament_id}/addteam/{team_id}")
    public String addTeamToTournament(@PathVariable int tournament_id, @PathVariable int team_id) {
        System.out.println("TournamentCotroller.addTeamToTournament");
        tournamentService.addTeamToTournament(tournament_id, team_id);
        return "Team added to tournament";
    }

    @GetMapping("/tournament/{tournament_id}/teams")
    public List<Team> getTeams(@PathVariable int tournament_id) {

        List<Team> teams = tournamentService.getTeams(tournament_id);
        return teams;
    }

    @GetMapping("/tournament/{tournament_id}/matches")
    public List<Match> getMatches(@PathVariable int tournament_id) {
        System.out.println("TournamentCotroller.getMatches");
        return tournamentService.getMatches(tournament_id);
    }

    @PostMapping("/tournament/addmatch")
    public String addMatchToTournament(@RequestBody MatchRequest request) {
        System.out.println("TournamentCotroller.addMatchToTournament");
        System.out.println(request);
        return "Match added to tournament";
//        return tournamentService.addMatchToTournament(request.getTournament_id(), request.getTeam1_id(), request.getTeam2_id() , request.getMatch_date() );
    }

    @PostMapping("/tournament/check")
    public String check(@RequestBody String tournament_id) {
        return "tournament_id: " + tournament_id;
    }

}
