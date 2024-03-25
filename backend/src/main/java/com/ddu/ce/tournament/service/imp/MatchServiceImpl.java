package com.ddu.ce.tournament.service.imp;

import com.ddu.ce.tournament.dao.MatchDAO;
import com.ddu.ce.tournament.dao.TeamDAO;
import com.ddu.ce.tournament.entity.Match;
import com.ddu.ce.tournament.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements com.ddu.ce.tournament.service.MatchService{

    private MatchDAO matchDAO;
    private TeamDAO teamDAO;
    @Autowired
    public MatchServiceImpl(MatchDAO matchDAO, TeamDAO teamDAO) {
        this.matchDAO = matchDAO;
        this.teamDAO = teamDAO;
    }

    public MatchDAO getMatchDAO() {
        return matchDAO;
    }

    public TeamDAO getTeamDAO() {
        return teamDAO;
    }


    public Match updateMatchScore(int matchId, int team1Score, int team2Score, int team1Wickets, int team2Wickets) {
        Match match = matchDAO.findById(matchId).get();
        match.setTeam1_score(team1Score);
        match.setTeam2_score(team2Score);
        match.setTeam1_wickets(team1Wickets);
        match.setTeam2_wickets(team2Wickets);
        matchDAO.save(match);
        return match;
    }

    public void setMatchDAO(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }


    public String save(Match match) {
        matchDAO.save(match);
        return "Match saved";
    }

    public Match findById(int id) {
        return matchDAO.findById(id).get();
    }

    public String deleteById(int id) {
        matchDAO.deleteById(id);
        return "Match deleted";
    }

    public Iterable<Match> findAll() {
        return matchDAO.findAll();
    }

    public void deleteAll() {
        matchDAO.deleteAll();
    }

    public Team setfirstbattingTeam(int matchId, int teamId) {
        Match match = matchDAO.findById(matchId).get();
        Team team= teamDAO.findById(teamId).get();
        match.setFirstbattingteam(team);
        matchDAO.save(match);
        return team;
    }

    public Team setmatchwinner(int matchId) {
        Match match = matchDAO.findById(matchId).get();
        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();

        if (match.getTeam1_score() > match.getTeam2_score()) {
            match.setWinner(team1);
            match.setMatch_status("completed");
            matchDAO.save(match);
            return team1;
        } else {
            match.setWinner(team2);
            match.setMatch_status("completed");
            matchDAO.save(match);
            return team2;
        }
    }

    public Team getmatchwinner(int matchId) {
        Match match = matchDAO.findById(matchId).get();
        return match.getWinner();
    }

}

