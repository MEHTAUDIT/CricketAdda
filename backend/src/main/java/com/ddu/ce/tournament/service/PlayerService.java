package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Player;
import com.ddu.ce.tournament.entity.Team;

import java.util.List;

public interface PlayerService {
    String save(Player player);
    Player findById(int id);
    String deleteById(int id);
    Iterable<Player> findAll();
    String deleteAll();
}
