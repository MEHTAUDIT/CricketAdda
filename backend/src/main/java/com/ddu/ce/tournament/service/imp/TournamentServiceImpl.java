package com.ddu.ce.tournament.service.imp;

import com.ddu.ce.tournament.dao.MatchDAO;
import com.ddu.ce.tournament.dao.TeamDAO;
import com.ddu.ce.tournament.dao.TournamentDAO;
import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Team;
import com.ddu.ce.tournament.entity.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TournamentServiceImpl implements com.ddu.ce.tournament.service.TournamentService{

    private TournamentDAO tournamentDAO;
    private TeamDAO teamDAO;
    private MatchDAO matchDAO;
    @Autowired
    public TournamentServiceImpl(TournamentDAO tournamentDAO , TeamDAO teamDAO , MatchDAO matchDAO) {
        this.tournamentDAO = tournamentDAO;
        this.teamDAO = teamDAO;
        this.matchDAO = matchDAO;
    }

    public TournamentDAO getTournamentDAO() {
        return tournamentDAO;
    }

    public void setTournamentDAO(TournamentDAO tournamentDAO) {
        this.tournamentDAO = tournamentDAO;
    }

    public String save(Tournament tournament) {
        tournamentDAO.save(tournament);
        return "Tournament saved";
    }

    public Tournament findById(int id) {
        return tournamentDAO.findById(id).get();
    }

    public String deleteById(int id) {
        tournamentDAO.deleteById(id);
        return "Tournament deleted";
    }


    public List<Tournament> findAll() {
        return tournamentDAO.findAll();
    }

    public void deleteAll() {
        tournamentDAO.deleteAll();
    }

    public String addTeamToTournament(int tournament_id, int team_id) {

        Tournament tournament = tournamentDAO.findById(tournament_id).get();
        Team team = teamDAO.findById(team_id).get();
        tournament.getTeams().add(team);
        tournamentDAO.save(tournament);
        return "Team added to tournament";
    }

    public List<Team> getTeams(int tournament_id) {
//        System.out.println("TournamentServiceImpl.getTeams");
        Tournament tournament = findById(tournament_id);


        return tournament.getTeams();
    }

    public List<Match> getMatches(int tournament_id) {
        Tournament tournament = findById(tournament_id);
        List<Match> matches = matchDAO.findByTournament_Id(tournament_id);
        return matches;
    }

    public String addMatchToTournament(int tournament_id, int team1_id, int team2_id , String match_date ){
        Match match = new Match();
        match.setTeam1(teamDAO.findById(team1_id).get());
        match.setTeam2(teamDAO.findById(team2_id).get());
        match.setMatch_status("upcoming");
        match.setWinner(0);
        match.setMatch_date(match_date);
        match.setTournament(findById(tournament_id));
        matchDAO.save(match);
        return "Match added to tournament";
    }

}
