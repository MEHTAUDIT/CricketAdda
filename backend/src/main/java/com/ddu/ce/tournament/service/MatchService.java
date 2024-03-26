package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Team;

public interface MatchService {
    String save(Match match);
    Match findById(int id);
    String deleteById(int id);
    Iterable<Match> findAll();
    void deleteAll();

    Match updateMatchScore( int matchId, int team1Score, int team2Score, int team1Wickets, int team2Wickets);

    Team setmatchwinner(int matchId);

    Team setfirstbattingTeam(int matchId, int teamId);

    Team getmatchwinner(int matchId);



}
