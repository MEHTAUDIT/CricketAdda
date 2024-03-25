package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.Tournament;

import java.util.Date;
import java.util.List;

public interface TournamentService {
    void save(Tournament tournament);
    Tournament findById(int id);
    void deleteById(int id);
    List<Tournament> findAll();
    void deleteAll();

    void addTeamToTournament(int tournament_id, int team_id);

    List<Team> getTeams(int tournament_id);

    List<Match> getMatches(int tournament_id);

    void addMatchToTournament(int tournament_id, int team1_id, int team2_id , String match_date); ;
}
