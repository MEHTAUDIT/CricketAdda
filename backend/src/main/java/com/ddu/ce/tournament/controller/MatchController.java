package com.ddu.ce.tournament.controller;

import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.payload.request.UpdateMatchScore;
import com.ddu.ce.tournament.payload.response.MatchScoreResponse;
import com.ddu.ce.tournament.payload.response.UserInfoResponse;
import com.ddu.ce.tournament.service.MatchService;
import com.ddu.ce.tournament.service.imp.MatchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173"  )
public class MatchController {

    @Autowired
    private MatchServiceImpl matchService;

    @GetMapping("")
    public String home() {
        return "Welcome to the Tournament API , please use the following endpoints: /player, /team, /match, /tournament";
    }

   @PostMapping("/match")
   @PreAuthorize("hasRole('ADMIN')")
    public String createMatch(@RequestBody Match match) {
        System.out.println("MatchController.createMatch");
        matchService.save(match);
        return "Match saved";
    }

    @GetMapping("/match/{id}")
    public Match findMatch(@PathVariable int id) {
        System.out.println("MatchController.findMatch");
        return matchService.findById(id);
    }

    @DeleteMapping("/match/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteMatch(@PathVariable int id) {
        System.out.println("MatchController.deleteMatch");
        matchService.deleteById(id);
        return "Match deleted";
    }

    @GetMapping("/matches")
    public Iterable<Match> findAllMatches() {
        System.out.println("MatchController.findAllMatches");
        return matchService.findAll();
    }

    @PutMapping("/match")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateMatch(@RequestBody Match match) {
        System.out.println("MatchController.updateMatch");
        matchService.save(match);
        return "Match updated";
    }

    @PutMapping("/match/updatescore")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateMatchScore(@RequestBody UpdateMatchScore updateMatchScore) {
        System.out.println("MatchController.updateMatchScore");
        Match match= matchService.updateMatchScore(updateMatchScore.getMatchId(), updateMatchScore.getTeam1Score(), updateMatchScore.getTeam2Score(), updateMatchScore.getTeam1Wickets(), updateMatchScore.getTeam2Wickets());
        return ResponseEntity.ok()
                .body(new MatchScoreResponse(match.getId() , match.getTeam1().getTeam_name() , match.getTeam2().getTeam_name() , match.getTeam1_score() , match.getTeam2_score() , match.getTeam1_wickets() , match.getTeam2_wickets()));
    }

    @PostMapping("/match/{matchId}/winner")
    public Team setMatchWinner(@PathVariable int matchId) {
        System.out.println("MatchController.setMatchWinner");
        return matchService.setmatchwinner(matchId);
    }

    @PostMapping("/match/{matchId}/team/{teamId}/firstbatting")
    public Team setFirstBattingTeam(@PathVariable int matchId, @PathVariable int teamId) {
        System.out.println("MatchController.setFirstBattingTeam");
        return matchService.setfirstbattingTeam(matchId, teamId);
    }

    @GetMapping("/match/{matchId}/winner")
    public Team getMatchWinner(@PathVariable int matchId) {
        System.out.println("MatchController.getMatchWinner");
        return matchService.getmatchwinner(matchId);
    }

}
