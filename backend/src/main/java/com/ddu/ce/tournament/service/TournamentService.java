package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Tournament;

public interface TournamentService {
    void save(Tournament tournament);
    Tournament findById(int id);
    void deleteById(int id);
    Iterable<Tournament> findAll();
    void deleteAll();
}
