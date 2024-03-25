package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Match;

public interface MatchService {
    void save(Match match);
    Match findById(int id);
    void deleteById(int id);
    Iterable<Match> findAll();
    void deleteAll();

    Match updateMatchScore( int matchId, int team1Score, int team2Score, int team1Wickets, int team2Wickets);
}