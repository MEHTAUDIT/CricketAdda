package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Team;

public interface TeamService {
    void save(Team team);
    Team findById(int id);
    void deleteById(int id);
    Iterable<Team> findAll();
    void deleteAll();
}
