package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.Tournament;
import com.ddu.ce.tournament.payload.request.TournamentRequest;

import java.util.Date;
import java.util.List;

public interface TournamentService {
    String save(TournamentRequest tournament);
    Tournament findById(int id);
    String deleteById(int id);
    List<Tournament> findAll();
    void deleteAll();

    String addTeamToTournament(int tournament_id, int team_id);

    List<Team> getTeams(int tournament_id);

    List<Match> getMatches(int tournament_id);

    public String addMatchToTournament(int tournament_id, int team1_id, int team2_id , String match_date );
}
