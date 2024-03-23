package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Match;

public interface MatchService {
    void save(Match match);
    Match findById(int id);
    void deleteById(int id);
    Iterable<Match> findAll();
    void deleteAll();
}