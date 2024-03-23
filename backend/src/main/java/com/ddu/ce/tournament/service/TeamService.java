package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.entity.Team;

import java.util.List;

public interface TeamService {
    void save(Team team);
    Team findById(int id);
    void deleteById(int id);
    Iterable<Team> findAll();
    void deleteAll();

    void addPlayerToTeam(int team_id, int player_id);

    List<Player> getPlayers(int team_id);

}
