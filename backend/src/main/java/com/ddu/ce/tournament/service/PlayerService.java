package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.dao.PlayerDAO;

import com.ddu.ce.tournament.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerDAO playerDAO;

    @Autowired
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public PlayerDAO getPlayerDAO() {
        return playerDAO;
    }

    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void save(Player player) {
        playerDAO.save(player);
    }

    public Player findById(int id) {
        return playerDAO.findById(id).get();
    }

    public void deleteById(int id) {
        playerDAO.deleteById(id);
    }

    public Iterable<Player> findAll() {
        return playerDAO.findAll();
    }

    public void deleteAll() {
        playerDAO.deleteAll();
    }



}
