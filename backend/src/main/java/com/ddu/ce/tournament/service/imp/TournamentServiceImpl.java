package com.ddu.ce.tournament.service.imp;

import com.ddu.ce.tournament.dao.TeamDAO;
import com.ddu.ce.tournament.dao.TournamentDAO;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentServiceImpl implements com.ddu.ce.tournament.service.TournamentService{

    private TournamentDAO tournamentDAO;
    private TeamDAO teamDAO;

    @Autowired
    public TournamentServiceImpl(TournamentDAO tournamentDAO , TeamDAO teamDAO) {
        this.tournamentDAO = tournamentDAO;
        this.teamDAO = teamDAO;
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


    public List<Tournament> findAll() {
        return tournamentDAO.findAll();
    }

    public void deleteAll() {
        tournamentDAO.deleteAll();
    }

    public void addTeamToTournament(int tournament_id, int team_id) {

        Tournament tournament = tournamentDAO.findById(tournament_id).get();
        Team team = teamDAO.findById(team_id).get();
        tournament.getTeams().add(team);
        tournamentDAO.save(tournament);
    }

    public List<Team> getTeams(int tournament_id) {
//        System.out.println("TournamentServiceImpl.getTeams");
        Tournament tournament = findById(tournament_id);


        return tournament.getTeams();
    }



}
