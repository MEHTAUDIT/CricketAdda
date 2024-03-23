package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.entity.Player;

public interface PlayerService {
    void save(Player player);
    Player findById(int id);
    void deleteById(int id);
    Iterable<Player> findAll();
    void deleteAll();
}
