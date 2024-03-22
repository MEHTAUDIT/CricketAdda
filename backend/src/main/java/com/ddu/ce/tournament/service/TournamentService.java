package com.ddu.ce.tournament.service;

import com.ddu.ce.tournament.dao.TournamentDAO;
import com.ddu.ce.tournament.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {

    private TournamentDAO tournamentDAO;

    @Autowired
    public TournamentService(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public TournamentDAO getTournamentDAO() {
        return tournamentDAO;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public void save(Tournament tournament) {
        tournamentDAO.save(tournament);
    }

    public Tournament findById(int id) {
        return tournamentDAO.findById(id).get();
    }

    public void deleteById(int id) {
        tournamentDAO.deleteById(id);
    }

    public Iterable<Tournament> findAll() {
        return tournamentDAO.findAll();
    }

    public void deleteAll() {
        tournamentDAO.deleteAll();
    }



}
